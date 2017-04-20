package com.github.mauricioaniche.mc.metrics.ck;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.Modifier;

import com.github.mauricioaniche.mc.Metric;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;

public class NOSI extends ASTVisitor implements Metric {

	private int count = 0;

	public boolean visit(MethodInvocation node) {

		IMethodBinding binding = node.resolveMethodBinding();
		if(binding!=null && Modifier.isStatic(binding.getModifiers()))
				count++;
		
		return super.visit(node);
	}

	@Override
	public void setResult(MetricsNumber result) {
		((CKNumber)result).setNosi(count);
	}

	@Override
	public void execute(CompilationUnit cu, MetricsNumber number, MetricsReport report) {
		cu.accept(this);
	}
	
}
