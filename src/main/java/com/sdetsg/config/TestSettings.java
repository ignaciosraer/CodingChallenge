package com.sdetsg.config;

import org.testng.annotations.AfterTest;

/**
 * Configuration file for the tests
 * @author Ignacio Sraer
 *
 */
public class TestSettings extends ProjectSettings {
	
	
	@AfterTest
	public void endReport() {
		driver.quit();
	}
}