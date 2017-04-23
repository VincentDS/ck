package com.github.mauricioaniche.mc.metrics.selenium;

import com.github.mauricioaniche.mc.MetricsNumber;

public class SeleniumNumber extends MetricsNumber {
	
	private int nos; //nr of selectors
	private int nosId;
	private int nosXPath; 
	private int nosCssSelector;
	private int nosName;
	private int nosTagName; 
	private int nosClassName; 
	private int nosLinkText; 
	
	private int nose; //nr of script executions

	public SeleniumNumber(String file, String className, String type) {
		super(file, className, type);
	}
	
	
	public int getNos() {
		return nos;
	}
	
	public void setNos(int nos) {
		this.nos = nos;
	}


	public int getNosId() {
		return nosId;
	}


	public void setNosId(int nosId) {
		this.nosId = nosId;
	}


	public int getNosXPath() {
		return nosXPath;
	}


	public void setNosXPath(int nosXPath) {
		this.nosXPath = nosXPath;
	}


	public int getNosCssSelector() {
		return nosCssSelector;
	}


	public void setNosCssSelector(int noCssSelector) {
		this.nosCssSelector = noCssSelector;
	}


	public int getNosName() {
		return nosName;
	}


	public void setNosName(int nosName) {
		this.nosName = nosName;
	}


	public int getNosTagName() {
		return nosTagName;
	}


	public void setNosTagName(int nosTagName) {
		this.nosTagName = nosTagName;
	}


	public int getNosClassName() {
		return nosClassName;
	}


	public void setNosClassName(int nosClassName) {
		this.nosClassName = nosClassName;
	}


	public int getNosLinkText() {
		return nosLinkText;
	}


	public void setNosLinkText(int nosLinkText) {
		this.nosLinkText = nosLinkText;
	}
	
	public int getNose() {
		return nose;
	}


	public void setNose(int nose) {
		this.nose = nose;
	}

	@Override
	public String toString() {
		return "SeleniumNumber [className=" + className + ", type=" + type + ", nose=" + nose + ", nos=" + nos + ", nosId=" + nosId + ", nosXPath=" + nosXPath + ", nosCssSelector=" + nosCssSelector 
				+ ", nosName=" + nosName + ", nosTagName=" + nosTagName + ", nosClassName=" + nosClassName + ", nosLinkText=" + nosLinkText + ", loc=" + loc + ", specific=" + specific + ", error=" + error + "]";
	}


}
