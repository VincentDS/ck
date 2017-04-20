package com.github.mauricioaniche.mc.metric.selenium;

import com.github.mauricioaniche.mc.metric.BaseTest;
import java.io.File;
import java.io.IOException;

abstract class SeleniumTest implements BaseTest {

	public static String fixturesDir() {
		try {
			String cfgFile = new File("." + "../../fixtures/selenium/").getCanonicalPath();
			return cfgFile;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
