package com.github.mauricioaniche.mc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;

import com.github.mauricioaniche.mc.metrics.ck.*;
//import com.github.mauricioaniche.mc.metrics.junit.*;
import com.github.mauricioaniche.mc.metrics.selenium.*;
import com.google.common.collect.Lists;

public class MetricsCalculator {

	private String type = "all";
	private static final int MAX_AT_ONCE;
	
	static {
		String jdtMax = System.getProperty("jdt.max");
		if(jdtMax!=null) {
			MAX_AT_ONCE = Integer.parseInt(jdtMax);
		} else {
			long maxMemory= Runtime.getRuntime().maxMemory() / (1 << 20); // in MiB
			
			if      (maxMemory >= 2000) MAX_AT_ONCE= 400;
			else if (maxMemory >= 1500) MAX_AT_ONCE= 300;
			else if (maxMemory >= 1000) MAX_AT_ONCE= 200;
			else if (maxMemory >=  500) MAX_AT_ONCE= 100;
			else                        MAX_AT_ONCE=  25;
		}
	}

	public List<Callable<Metric>> pluggedMetrics; 
	private static Logger log = Logger.getLogger(MetricsCalculator.class);

	public MetricsCalculator() {
		this.pluggedMetrics = new ArrayList<>();
	}
	
	public MetricsCalculator plug(Callable<Metric> metric) {
		this.pluggedMetrics.add(metric);
		return this;
	}
	
	public MetricsReport calculate(String type, String path) {
		this.type = type;
		String[] srcDirs = FileUtils.getAllDirs(path);
		String[] javaFiles = FileUtils.getAllJavaFiles(path);
		log.info("Found " + javaFiles.length + " java files");
		
		MetricsExecutor storage = new MetricsExecutor(type, () -> metrics());
		
		List<List<String>> partitions = Lists.partition(Arrays.asList(javaFiles), MAX_AT_ONCE);
		log.info("Max partition size: " + MAX_AT_ONCE + ", total partitions=" + partitions.size());

		for(List<String> partition : partitions) {
			log.info("Next partition");
			ASTParser parser = ASTParser.newParser(AST.JLS8);
			
			String[] classpath = java.lang.System.getProperty("java.class.path").split(";");

//			System.out.println(Arrays.toString(classpath));
			
			parser.setResolveBindings(true);
			parser.setBindingsRecovery(true);
			parser.setKind(ASTParser.K_COMPILATION_UNIT);
			
			Map<?, ?> options = JavaCore.getOptions();
			JavaCore.setComplianceOptions(JavaCore.VERSION_1_8, options);
			parser.setCompilerOptions(options);
			parser.setEnvironment(classpath, srcDirs, null, true);
			parser.createASTs(partition.toArray(new String[partition.size()]), null, new String[0], storage, null);
		}
		
		log.info("Finished parsing");
		return storage.getReport();
	}
	
	private List<Metric> metrics() {
		List<Metric> metrics;
		switch (type) {
		case "ck":
			metrics = CKMetrics();
			break;
		case "junit":
			metrics = JUnitMetrics();
			break;
		case "selenium":
			metrics = SeleniumMetrics();
			break;
		default:
            throw new IllegalArgumentException("Invalid test type: " + type);
		}
		
		metrics.addAll(userMetrics());
		
		return metrics;
	}
	

	private List<Metric> CKMetrics() {
		return new ArrayList<>(Arrays.asList(new DIT(), new NOC(), new WMC(), new CBO(), new LCOM(), new RFC(), new NOM(),
				new NOF(), new NOPF(), new NOSF(),
				new NOPM(), new NOSM(), new NOSI()));
	}
	
	private List<Metric> JUnitMetrics() {
		return new ArrayList<>();
	}
	
	private List<Metric> SeleniumMetrics() {
		return new ArrayList<>(Arrays.asList(new NOSE(), new NOS()));
	}


	private List<Metric> userMetrics() {
		try {
			List<Metric> userMetrics = new ArrayList<Metric>();
			
			for(Callable<Metric> metricToBeCreated : pluggedMetrics) {
				userMetrics.add(metricToBeCreated.call());
			}

			return userMetrics;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
