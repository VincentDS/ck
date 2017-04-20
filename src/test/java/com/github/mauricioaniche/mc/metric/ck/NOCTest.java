package com.github.mauricioaniche.mc.metric.ck;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.mc.MetricsCalculator;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;
import com.github.mauricioaniche.mc.metrics.ck.CKNumber;

public class NOCTest extends CKTest {

	private static MetricsReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new MetricsCalculator().calculate("ck", fixturesDir() + "/dit");
	}
	
	@Test
	public void should_detect_children() {
		
		CKNumber a = (CKNumber) report.getByClassName("dit.A");
		Assert.assertEquals(1, a.getNoc());
		CKNumber b = (CKNumber) report.getByClassName("dit.B");
		Assert.assertEquals(2, b.getNoc());
		CKNumber c = (CKNumber) report.getByClassName("dit.C");
		Assert.assertEquals(1, c.getNoc());
		CKNumber d = (CKNumber) report.getByClassName("dit.D");
		Assert.assertEquals(0, d.getNoc());
	}
}
