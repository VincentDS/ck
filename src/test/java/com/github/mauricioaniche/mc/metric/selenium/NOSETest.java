package com.github.mauricioaniche.mc.metric.selenium;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.mc.MetricsCalculator;
import com.github.mauricioaniche.mc.MetricsReport;
import com.github.mauricioaniche.mc.metrics.selenium.SeleniumNumber;

public class NOSETest extends SeleniumTest {
	
	private static MetricsReport report;

	
	@BeforeClass
	public static void setUp() {
		report = new MetricsCalculator().calculate("selenium", fixturesDir() + "/nose");
	}
	
	@Test
	public void allWeakSelectors() {
		SeleniumNumber a = (SeleniumNumber) report.getByClassName("nose.nose");
		Assert.assertEquals(1, a.getNose());

	}

}
