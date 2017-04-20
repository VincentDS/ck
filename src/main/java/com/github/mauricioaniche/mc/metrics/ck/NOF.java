package com.github.mauricioaniche.mc.metrics.ck;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;

import com.github.mauricioaniche.mc.Metric;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;

public class NOF extends ASTVisitor implements Metric {

	private int fields;

	@Override
	public boolean visit(FieldDeclaration node) {
		fields++;

		return false;
	}

	@Override
	public void execute(CompilationUnit cu, MetricsNumber number, MetricsReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(MetricsNumber result) {
		((CKNumber)result).setNof(fields);
	}
}
