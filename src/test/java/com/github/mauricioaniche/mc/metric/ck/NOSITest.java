package com.github.mauricioaniche.mc.metric.ck;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.mc.MetricsCalculator;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;
import com.github.mauricioaniche.mc.metrics.ck.CKNumber;

public class NOSITest extends CKTest {

	private static MetricsReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new MetricsCalculator().calculate("ck", fixturesDir() + "/nosi");
	}
	
	@Test
	public void staticInvocations() {
		CKNumber a = (CKNumber) report.getByClassName("nosi.Class2");
		Assert.assertEquals(1, a.getNosi());
	}

	@Test
	public void staticInvocationsToMethodsInTheSameClass() {
		CKNumber a = (CKNumber) report.getByClassName("nosi.Class3");
		Assert.assertEquals(2, a.getNosi());
	}

	@Test
	public void doesNotUnderstandWhenNotResolvable() {
		CKNumber a = (CKNumber) report.getByClassName("nosi.Class1");
		Assert.assertEquals(0, a.getNosi());
	}
}
