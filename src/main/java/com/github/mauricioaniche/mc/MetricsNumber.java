package com.github.mauricioaniche.mc;

import java.util.HashMap;
import java.util.Map;

public class MetricsNumber {

	protected String file;
	protected String className;
	protected String type;
	
	protected int loc;
		
	protected Map<String, Integer> specific;
	protected boolean error; 

	public MetricsNumber(String file, String className, String type) {
		this.file = file;
		this.className = className;
		this.type = type;
		
		this.specific = new HashMap<String, Integer>();
	}
	
	public String getFile() {
		return file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((file == null) ? 0 : file.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetricsNumber other = (MetricsNumber) obj;
		if (file == null) {
			if (other.file != null)
				return false;
		} else if (!file.equals(other.file))
			return false;
		return true;
	}

	public int getSpecific(String key) {
		if(!specific.containsKey(key)) return -1;
		return specific.get(key);
	}
	
	public void addSpecific(String key, int value) {
		specific.put(key, value);
	}

	public String getType() {
		return type;
	}
	
	public void setFile(String file) {
		this.file = file;
	}

	public String getClassName() {
		return className;
	}
	
	public int getLoc() {
		return loc;
	}

	public void setLoc(int loc) {
		this.loc = loc;
	}


	public boolean isError() {
		return error;
	}
	
	public void error() {
		this.error = true;
	}

}
