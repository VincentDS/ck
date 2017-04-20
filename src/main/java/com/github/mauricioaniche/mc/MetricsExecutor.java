package com.github.mauricioaniche.mc;

import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.Callable;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FileASTRequestor;

import com.github.mauricioaniche.mc.metrics.ck.CKNumber;
import com.github.mauricioaniche.mc.metrics.ck.ClassInfo;
import com.github.mauricioaniche.mc.metrics.junit.JUnitNumber;
import com.github.mauricioaniche.mc.metrics.selenium.SeleniumNumber;

public class MetricsExecutor extends FileASTRequestor {

	private String type;
	private MetricsReport report;
	private Callable<List<Metric>> metrics;
	
	private static Logger log = Logger.getLogger(MetricsExecutor.class);
	
	public MetricsExecutor(String type, Callable<List<Metric>> metrics) {
		this.type = type;
		this.metrics = metrics;
		this.report = new MetricsReport();
	}


	@Override
	public void acceptAST(String sourceFilePath, CompilationUnit cu) {
		
		MetricsNumber result = null;
		
		try {
			ClassInfo info = new ClassInfo();
			cu.accept(info);
			if(info.getClassName()==null) return;
		
			result = createNumber(sourceFilePath, info);
			
			int loc = new LOCCalculator().calculate(new FileInputStream(sourceFilePath));
			result.setLoc(loc);
			
			for(Metric visitor : metrics.call()) {
				visitor.execute(cu, result, report);
				visitor.setResult(result);
			}
			log.info(result);
			report.add(result);
		} catch(Exception e) {
			if(result!=null) result.error();
			log.error("error in " + sourceFilePath, e);
		}
	}
	
	public MetricsReport getReport() {
		return report;
	}
	
	public MetricsNumber createNumber(String sourceFilePath, ClassInfo info) {
		MetricsNumber nr = null;
		switch (type) {
		case "ck":
			nr = new CKNumber(sourceFilePath, info.getClassName(), info.getType());
			break;
		case "junit":
			nr = new JUnitNumber(sourceFilePath, info.getClassName(), info.getType());
			break;
		case "selenium":
			nr = new SeleniumNumber(sourceFilePath, info.getClassName(), info.getType());
			break;
		}
		return nr;
	}
	
}
