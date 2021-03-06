package com.sdetsg.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import com.sdetsg.config.ProjectSettings;
import com.sdetsg.utility.Utils;

public class SingleProductPage extends ProjectSettings {

	//Locators
	By promoIframe = By.xpath("//iframe[contains(@src, 'campaign.aliexpress.com')]");
	By popUpCloseButton = By.xpath("//img[@class='rax-image ' and contains(@src, 'TB1a')]");
	By productQuantity = By.xpath("//div[@class='product-quantity-tip']//span");
	
	/**
	 * Verifies the quantity of products available for purchase
	 */
	public void verifyProductQuantity() {
		
		Utils.switchTabs(1);
			
		/**
		 * There's no need to close this popup here since I can get the quantity data without closing it
		 * but given it is a test I decided to show it is possible if I wanted to click something behind it
		 */
		try {
			if (Utils.waitUntilElementPresent(10, promoIframe)) {

				driver.switchTo().frame(driver.findElement(promoIframe));
				Utils.waitUntilElementPresent(20, popUpCloseButton);
				driver.findElement(popUpCloseButton).click();
				driver.switchTo().defaultContent();
			}
		} catch (TimeoutException e) {

			System.out.println("Promo popup was not present at single product page");
		}
		
		Utils.waitUntilElementPresent(10, productQuantity);
		
		
		String quantity = driver.findElement(productQuantity).getText();
		int value = Integer.parseInt(quantity.replaceAll("[^0-9]", ""));

		Assert.assertTrue(value >= 1);
	}
}
