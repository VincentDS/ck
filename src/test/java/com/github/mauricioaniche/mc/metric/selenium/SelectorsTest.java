package com.github.mauricioaniche.mc.metric.selenium;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.mc.MetricsCalculator;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;
import com.github.mauricioaniche.mc.metrics.ck.CKNumber;
import com.github.mauricioaniche.mc.metrics.selenium.SeleniumNumber;

public class SelectorsTest extends SeleniumTest {
	
	private static MetricsReport report;

	
	@BeforeClass
	public static void setUp() {
		report = new MetricsCalculator().calculate("selenium", fixturesDir() + "/selectors");
	}
	
	@Test
	public void allWeakSelectors() {
		SeleniumNumber a = (SeleniumNumber) report.getByClassName("selectors.Selectors");
		Assert.assertEquals(6, a.getNows());
	}

}
