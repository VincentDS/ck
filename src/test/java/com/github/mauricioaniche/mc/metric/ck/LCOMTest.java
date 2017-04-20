package com.github.mauricioaniche.mc.metric.ck;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.mc.MetricsCalculator;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;
import com.github.mauricioaniche.mc.metrics.ck.CKNumber;

public class LCOMTest extends CKTest {

	private static MetricsReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new MetricsCalculator().calculate("ck", fixturesDir() + "/lcom");
	}
	
	@Test
	public void should_count_lcom() {
		
		CKNumber a = (CKNumber) report.getByClassName("lcom.TripStatusBean");
		Assert.assertEquals(1415, a.getLcom());

		CKNumber b = (CKNumber) report.getByClassName("lcom.SimpleGetterAndSetter");
		Assert.assertEquals(0, b.getLcom());

		CKNumber c = (CKNumber) report.getByClassName("lcom.SimpleGetterAndSetter2");
		Assert.assertEquals(2, c.getLcom());

		CKNumber d = (CKNumber) report.getByClassName("lcom.TermsOfServiceController");
		Assert.assertEquals(0, d.getLcom());

	}
	
}
