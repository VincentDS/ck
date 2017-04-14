package com.github.mauricioaniche.ck.metric;

import java.io.File;
import java.io.IOException;

abstract class BaseTest {

	protected static String fixturesDir() {
		try {
			String cfgFile = new File("." + "../../fixtures/").getCanonicalPath();
			//System.out.println(BaseTest.class.getResource("/").getPath());
			System.out.println(cfgFile);
			return cfgFile;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
