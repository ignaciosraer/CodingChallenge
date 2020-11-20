package com.sdetsg.tests;

import org.testng.annotations.Test;
import com.sdetsg.config.TestSettings;
import com.sdetsg.pageobjects.HomePage;


public class QuantityOfProducts extends TestSettings {

	protected String url = "https://aliexpress.com";
	protected String product = "Iphone";
	protected int pageNumber = 2;
	protected int productNumber = 1;
	
	@Test
	public void ValidateQuantity() throws InterruptedException {

		HomePage home = new HomePage();
		
		home.goToHomePage(url)
			.closePromoPopUpIfPresent()
			.searchProduct(product)
			.switchPage(pageNumber)
			.accessProduct(productNumber)
			.verifyProductQuantity();
	}

	
}
