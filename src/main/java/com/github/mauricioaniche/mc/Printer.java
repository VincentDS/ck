package com.github.mauricioaniche.mc;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import com.github.mauricioaniche.mc.metrics.ck.CKNumber;
import com.github.mauricioaniche.mc.metrics.junit.JUnitNumber;
import com.github.mauricioaniche.mc.metrics.selenium.SeleniumNumber;


public class Printer {
	
	MetricsReport report;
	String csvPath;
	String type;

	public Printer(String type, MetricsReport report, String csvPath) {
		this.report = report;
		this.csvPath = csvPath;
		this.type = type;
	}

	public void print() throws FileNotFoundException {
		PrintStream ps = new PrintStream(csvPath);
		
		switch (type) {
		case "ck":
			for(MetricsNumber result : report.all()) {
				if(result.isError()) continue;
				CKNumber ck = (CKNumber)result;
				ps.println("file,class,type,cbo,wmc,dit,noc,rfc,lcom,nom,nopm,nosm,nof,nopf,nosf,nosi,loc");
				ps.println(
					ck.getFile() + "," +
					ck.getClassName() + "," +
					ck.getType() + "," +
					ck.getCbo() + "," +
					ck.getWmc() + "," +
					ck.getDit() + "," +
					ck.getNoc() + "," +
					ck.getRfc() + "," +
					ck.getLcom() + "," +
					ck.getNom() + "," +
					ck.getNopm() + "," + 
					ck.getNosm() + "," +
					ck.getNof() + "," +
					ck.getNopf() + "," + 
					ck.getNosf() + "," +
					ck.getNosi() + "," +
					ck.getLoc()
				);
			}
			break;
		case "junit":
			for(MetricsNumber result : report.all()) {
				if(result.isError()) continue;
				JUnitNumber junit = (JUnitNumber)result;
				ps.println("file,class,type,loc");
				ps.println(
					junit.getFile() + "," +
					junit.getClassName() + "," +
					junit.getType() + "," +
					junit.getLoc()
				);
			}
			break;
		case "selenium":
			for(MetricsNumber result : report.all()) {
				if(result.isError()) continue;
				SeleniumNumber selenium = (SeleniumNumber)result;
				ps.println("file,class,type,nows,loc");
				ps.println(
					selenium.getFile() + "," +
					selenium.getClassName() + "," +
					selenium.getType() + "," +
					selenium.getNose() + "," +
					selenium.getNos() + "," +
					selenium.getNosId() + "," +
					selenium.getNosXPath() + "," +
					selenium.getNosCssSelector() + "," +
					selenium.getNosName() + "," +
					selenium.getNosClassName() + "," +
					selenium.getNosTagName() + "," +
					selenium.getNosLinkText() + ", " + 
					selenium.getLoc()
				);
			}
			break;
		default:
            throw new IllegalArgumentException("Invalid test type: " + type);
		}
		ps.close();
		
	}
}
