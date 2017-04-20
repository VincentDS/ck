package com.github.mauricioaniche.mc.metrics.junit;

import com.github.mauricioaniche.mc.MetricsNumber;

public class JUnitNumber extends MetricsNumber {
		

	public JUnitNumber(String file, String className, String type) {
		super(file, className, type);
	}


	@Override
	public String toString() {
		return "JUnitNumber [file=" + file + ", className=" + className + ", type=" + type
				+ ", loc=" + loc + ", specific=" + specific + ", error=" + error + "]";
	}


}
