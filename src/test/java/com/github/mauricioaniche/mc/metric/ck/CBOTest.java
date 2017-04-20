package com.github.mauricioaniche.mc.metric.ck;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.mc.MetricsCalculator;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;
import com.github.mauricioaniche.mc.metrics.ck.CKNumber;

public class CBOTest extends CKTest {

	private static MetricsReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new MetricsCalculator().calculate("ck", fixturesDir() + "/cbo");
	}
	
	@Test
	public void ignoreJavaTypes() {
		CKNumber a = (CKNumber) report.getByClassName("cbo.Coupling0");
		Assert.assertEquals(0, a.getCbo());
	}
	
	@Test
	public void countDifferentPossibilitiesOfDependencies() {
		
		CKNumber a = (CKNumber) report.getByClassName("cbo.Coupling1");
		Assert.assertEquals(7, a.getCbo());
	}
	
	@Test
	public void countEvenWhenNotResolved() {
		
		CKNumber a = (CKNumber) report.getByClassName("cbo.Coupling3");
		Assert.assertEquals(1, a.getCbo());
	}
	
	@Test
	public void countInterfacesAndInheritances() {
		
		CKNumber b = (CKNumber) report.getByClassName("cbo.Coupling2");
		Assert.assertEquals(5, b.getCbo());
	}

	@Test
	public void countClassCreations() {
		
		CKNumber b = (CKNumber) report.getByClassName("cbo.Coupling4");
		Assert.assertEquals(3, b.getCbo());
	}

	@Test
	public void countMethodParameters() {
		
		CKNumber b = (CKNumber) report.getByClassName("cbo.MethodParams");
		Assert.assertEquals(2, b.getCbo());
	}
}
