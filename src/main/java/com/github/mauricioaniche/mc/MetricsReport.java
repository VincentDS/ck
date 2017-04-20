package com.github.mauricioaniche.mc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MetricsReport {

	private Map<String, MetricsNumber> results;

	public MetricsReport() {
		this.results = new HashMap<String, MetricsNumber>();
	}

	public void add(MetricsNumber ck) {
		results.put(ck.getFile(), ck);
	}

	public MetricsNumber get(String name) {
		return results.get(name);
	}

	public Collection<MetricsNumber> all() {
		return results.values();
	}

	public MetricsNumber getByClassName(String name) {
		for (MetricsNumber nr : all()) {
			if (nr.getClassName().equals(name))
				return nr;
		}

		return null;
	}
}
