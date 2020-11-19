package com.sdetsg.tests;
import org.testng.annotations.Test;

import com.sdetsg.config.TestSettings;
import com.sdetsg.pageobjects.HomePage;


public class Aliexpress extends TestSettings {

	protected String url = "https://aliexpress.com";
	protected String product = "Iphone";
	
	@Test
	public void ValidateQuantity() throws InterruptedException {

		HomePage home = new HomePage();
		
		home.goToHomePage(url).searchProduct(product).switchPage().accessProduct().verifyProductQuantity();
	}

	
}
