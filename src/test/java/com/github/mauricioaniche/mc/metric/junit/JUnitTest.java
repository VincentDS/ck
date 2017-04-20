package com.github.mauricioaniche.mc.metric.junit;

import com.github.mauricioaniche.mc.metric.BaseTest;
import java.io.File;
import java.io.IOException;

abstract class JUnitTest implements BaseTest {

	public String fixturesDir() {
		try {
			String cfgFile = new File("." + "../../fixtures/junit/").getCanonicalPath();
			return cfgFile;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
