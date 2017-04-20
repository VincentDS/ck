package com.github.mauricioaniche.mc.metric.ck;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.mc.MetricsCalculator;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;
import com.github.mauricioaniche.mc.metrics.ck.CKNumber;

public class DITTest extends CKTest {

	private static MetricsReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new MetricsCalculator().calculate("ck", fixturesDir() + "/dit");
	}
	
	@Test
	public void everyOneHasObjectAsFather() {
		CKNumber a = (CKNumber) report.getByClassName("dit.A");
		Assert.assertEquals(1, a.getDit());
	}

	@Test
	public void firstLevelInheritance() {
		CKNumber b = (CKNumber) report.getByClassName("dit.B");
		Assert.assertEquals(2, b.getDit());
	}
	
	@Test
	public void twoLevelsInheritance() {
		CKNumber c = (CKNumber) report.getByClassName("dit.C");
		Assert.assertEquals(3, c.getDit());

		CKNumber c2 = (CKNumber) report.getByClassName("dit.C2");
		Assert.assertEquals(3, c2.getDit());
	}
	
	@Test
	public void threeLevelsInheritance() {
		CKNumber d = (CKNumber) report.getByClassName("dit.D");
		Assert.assertEquals(4, d.getDit());
	}
	
	@Test
	public void countEvenClassesNotResolved() {
		CKNumber a = (CKNumber) report.getByClassName("dit.X");
		Assert.assertEquals(2, a.getDit());
	}

}
