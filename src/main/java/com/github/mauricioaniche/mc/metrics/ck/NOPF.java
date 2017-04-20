package com.github.mauricioaniche.mc.metrics.ck;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.Modifier;

import com.github.mauricioaniche.mc.Metric;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;

public class NOPF extends ASTVisitor implements Metric {

	private int fields;

	@Override
	public boolean visit(FieldDeclaration node) {
		if(Modifier.isPublic(node.getModifiers())) 
			fields++;

		return false;
	}

	@Override
	public void execute(CompilationUnit cu, MetricsNumber number, MetricsReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(MetricsNumber result) {
		((CKNumber)result).setNopf(fields);
	}
}
