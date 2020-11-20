package com.sdetsg.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import com.sdetsg.config.ProjectSettings;
import com.sdetsg.utility.Utils;

public class SearchResultsPage extends ProjectSettings {

	//Locators	
	String popUpCloseButton = "//div[contains(@class, 'ui-newuser-layer-dialog')]//a[@role='button']";
	//TODO: change to be able to select the desired page with a param
	String pageSelector = "//div[@class='next-pagination-list']//button[text()='2']";
	//TODO: change to be able to select the desired product with a param
	String productSelector = "//div[@product-index='1']";
	
	
	public SearchResultsPage switchPage() {
		
		try {
			if (Utils.waitUntilElementPresent(20, By.xpath(popUpCloseButton))) {

				driver.findElement(By.xpath(popUpCloseButton)).click();
			}
		} catch (TimeoutException e) {

			System.out.println("Promo popup was not present at search results page");
		}
		
		//TODO: revise this in order to improve stability
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollBy(0, document.body.scrollHeight-2000)");
		
		Utils.waitUntilElementPresent(20, By.xpath(pageSelector));
		driver.findElement(By.xpath(pageSelector)).click();
				
		return new SearchResultsPage();
	}
	
	public SingleProductPage accessProduct() {
		
		
		//TODO: replace thread sleep with a proper wait
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath(productSelector)).click();
		
		return new SingleProductPage();
	}
}
