package com.github.mauricioaniche.mc.metric.ck;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.github.mauricioaniche.mc.MetricsCalculator;
import com.github.mauricioaniche.mc.MetricsNumber;
import com.github.mauricioaniche.mc.MetricsReport;
import com.github.mauricioaniche.mc.metrics.ck.CKNumber;

public class RFCTest extends CKTest {

	private static MetricsReport report;
	
	@BeforeClass
	public static void setUp() {
		report = new MetricsCalculator().calculate("ck", fixturesDir() + "/rfc");
	}

	@Test
	public void countMethodInvocations() {
		CKNumber a = (CKNumber) report.getByClassName("rfc.GO");
		Assert.assertEquals(3, a.getRfc());
	}

	@Test
	public void countSuperInvocations() {
		CKNumber a = (CKNumber) report.getByClassName("rfc.GO3");
		Assert.assertEquals(2, a.getRfc());
	}

	@Test
	public void notPossibleToDifferentiateTypesWithStaticAnalysis() {
		CKNumber a = (CKNumber) report.getByClassName("rfc.RFC3");
		Assert.assertEquals(1, a.getRfc());
	}

	@Test
	public void doesNotCountConstructorInvocations() {
		CKNumber a = (CKNumber) report.getByClassName("rfc.RFC2");
		Assert.assertEquals(0, a.getRfc());
	}
}
