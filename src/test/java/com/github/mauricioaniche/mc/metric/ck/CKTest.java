package com.github.mauricioaniche.mc.metric.ck;

import com.github.mauricioaniche.mc.metric.BaseTest;
import java.io.File;
import java.io.IOException;

abstract class CKTest implements BaseTest {

	public static String fixturesDir() {
		try {
			String cfgFile = new File("." + "../../fixtures/ck/").getCanonicalPath();
			return cfgFile;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
