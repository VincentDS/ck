package com.github.mauricioaniche.mc.metric.ck;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.mc.MetricsCalculator;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;
import com.github.mauricioaniche.mc.metrics.ck.CKNumber;

public class MethodsTest extends CKTest {

	private static MetricsReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new MetricsCalculator().calculate("ck", fixturesDir() + "/methods");
	}
	
	@Test
	public void all() {
		CKNumber a = (CKNumber) report.getByClassName("methods.Methods");
		Assert.assertEquals(5, a.getNom());
	}

	@Test
	public void allPublic() {
		CKNumber a = (CKNumber) report.getByClassName("methods.Methods");
		Assert.assertEquals(2, a.getNopm());
	}

	@Test
	public void allStatic() {
		CKNumber a = (CKNumber) report.getByClassName("methods.Methods");
		Assert.assertEquals(2, a.getNosm());
	}
}
