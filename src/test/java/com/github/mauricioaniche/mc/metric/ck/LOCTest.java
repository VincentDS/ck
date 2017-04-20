package com.github.mauricioaniche.mc.metric.ck;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.mc.MetricsCalculator;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;

public class LOCTest extends CKTest {

	private static MetricsReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new MetricsCalculator().calculate("ck", fixturesDir() + "/cbo");
	}
	
	@Test
	public void countLinesIgnoringEmptyLines() {
		MetricsNumber a = report.getByClassName("cbo.Coupling1");
		Assert.assertEquals(11, a.getLoc());
	}
	
}
