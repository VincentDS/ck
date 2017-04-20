package com.github.mauricioaniche.mc.metrics.selenium;

import com.github.mauricioaniche.mc.MetricsNumber;

public class SeleniumNumber extends MetricsNumber {
	
	private int nows;
	

	public SeleniumNumber(String file, String className, String type) {
		super(file, className, type);
	}
	
	
	public int getNows() {
		return nows;
	}
	
	public void setNows(int nows) {
		this.nows = nows;
	}

	@Override
	public String toString() {
		return "SeleniumNumber [className=" + className + ", type=" + type + ", nows=" + nows
				+ ", loc=" + loc + ", specific=" + specific + ", error=" + error + "]";
	}


}
