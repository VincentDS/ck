package com.github.mauricioaniche.mc;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Runner {

	public static void main(String[] args) throws FileNotFoundException {
		
		if(args==null || args.length < 2) {
			System.out.println("Usage java -jar ck.jar <ck/junit/selenium> <path to project> <path to csv>");
			System.exit(1);
		}
		
		String type = args[0];
		String path = args[1];
		String csvPath = args[2];
		
		MetricsReport report = new MetricsCalculator().calculate(type,path);
		
		new Printer(type,report,csvPath).print();
		
		
	}
}
