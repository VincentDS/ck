package com.github.mauricioaniche.mc;

import org.eclipse.jdt.core.dom.CompilationUnit;

public interface Metric {

	void execute(CompilationUnit cu, MetricsNumber result, MetricsReport report);
	void setResult(MetricsNumber result);
}
