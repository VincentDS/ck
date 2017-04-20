package com.github.mauricioaniche.mc.metrics.selenium;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;

import com.github.mauricioaniche.mc.Metric;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;

public class NOWS extends ASTVisitor implements Metric {

	private int weakSelectors;
	
	@Override
	public boolean visit(MethodInvocation node) {
		String name = node.getName().getIdentifier();
		if (name.equals("findElement")) {
			String selector = getSelectorType(node);
			if (!selector.equals("id")) {
				weakSelectors++;
			}
		}
		return false;
	}
	
	public String getSelectorType(MethodInvocation inv) {
		String selector = null;
		
//		IMethodBinding binding = node.resolveMethodBinding();
//		String bindingName = binding.getName();
		MethodInvocation invocation = (MethodInvocation) inv.arguments().get(0);
//		ITypeBinding binding = arg.resolveTypeBinding();
		Expression expr = invocation.getExpression();
		if (expr.toString().equals("By")) {
			selector = invocation.getName().getIdentifier();
		}
		return selector;

	}
	
	@Override
	public void execute(CompilationUnit cu, MetricsNumber result, MetricsReport report) {
		cu.accept(this);
	}

	@Override
	public void setResult(MetricsNumber result) {
		((SeleniumNumber)result).setNows(weakSelectors);
	}

}
