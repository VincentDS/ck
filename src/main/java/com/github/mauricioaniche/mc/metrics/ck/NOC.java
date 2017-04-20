package com.github.mauricioaniche.mc.metrics.ck;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import com.github.mauricioaniche.mc.Metric;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;

public class NOC extends ASTVisitor implements Metric {

	private MetricsReport report;

	@Override
	public boolean visit(TypeDeclaration node) {
		ITypeBinding binding = node.resolveBinding();
		ITypeBinding father = binding.getSuperclass();
		if(father!=null) {
			CKNumber fatherCk = (CKNumber) report.getByClassName(father.getBinaryName());
			if(fatherCk!=null) fatherCk.incNoc();
		}

		return false;
	}

	@Override
	public void execute(CompilationUnit cu, MetricsNumber number, MetricsReport report) {
		this.report = report;
		cu.accept(this);
	}

	@Override
	public void setResult(MetricsNumber result) {
	}
}
