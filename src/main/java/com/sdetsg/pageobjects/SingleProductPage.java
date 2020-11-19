package com.sdetsg.pageobjects;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.sdetsg.config.ProjectSettings;
import com.sdetsg.utility.Utils;

public class SingleProductPage extends ProjectSettings {

	String popUpCloseButton = "//img[@class='rax-image ' and @data-spm-anchor-id]";
	String productQuantity = "//div[@class='product-quantity-tip']//span";
	
	
	public void verifyProductQuantity() {
		
		//TODO: figure out a way to close the popup
		//if(driver.findElement(By.xpath(popUpCloseButton)).isDisplayed()) {
			//driver.findElement(By.xpath(popUpCloseButton)).click();
		//}
		
		//TODO: replace thread sleep with a proper wait
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Utils.switchTabs(1);
		
		String quantity = driver.findElement(By.xpath(productQuantity)).getText();
		String[] parts = quantity.split(" ");
		
		Assert.assertTrue(Integer.parseInt(parts[0]) >= 1);
		
	}
}
