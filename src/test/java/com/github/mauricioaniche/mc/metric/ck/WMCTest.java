package com.github.mauricioaniche.mc.metric.ck;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.mc.MetricsCalculator;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;
import com.github.mauricioaniche.mc.metrics.ck.CKNumber;

public class WMCTest extends CKTest {

	private static MetricsReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new MetricsCalculator().calculate("ck", fixturesDir() + "/wmc");
	}

	@Test
	public void countAllBranchInstructions() {
		
		CKNumber a = (CKNumber) report.getByClassName("wmc.CC1");
		Assert.assertEquals(5, a.getWmc());
		CKNumber b = (CKNumber) report.getByClassName("wmc.CC2");
		Assert.assertEquals(5, b.getWmc());
	}
}
