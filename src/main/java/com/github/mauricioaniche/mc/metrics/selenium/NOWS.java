package com.github.mauricioaniche.mc.metrics.selenium;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;

import com.github.mauricioaniche.mc.Metric;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;

public class NOWS extends ASTVisitor implements Metric {

	private int weakSelectors;
	private static Logger log = Logger.getLogger(Metric.class);

	
	@Override
	public boolean visit(MethodInvocation node) {
		IMethodBinding binding = getMethodBinding(node);
		String name = binding.getName();
		if (name.equals("findElement")) {
			MethodInvocation argument = (MethodInvocation) node.arguments().get(0);
			String selector = getSelectorType(argument);
			if (!selector.equals("id")) {
				weakSelectors++;
			}
		}
		return false;
	}
	
	public String getSelectorType(MethodInvocation inv) {
		String selector = null;
		
		Expression expr = inv.getExpression();
		if (expr.toString().equals("By")) {
			IMethodBinding binding = getMethodBinding(inv);
			selector = binding.getName();
		}
		return selector;
	}
	
	public IMethodBinding getMethodBinding(MethodInvocation inv) {
		IMethodBinding binding = inv.resolveMethodBinding();
		if (binding == null) {
			log.info("Couldn't resolve method binding");
		}
		return binding;
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
