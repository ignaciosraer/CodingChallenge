package com.sdetsg.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.sdetsg.config.ProjectSettings;

public class SearchResultsPage extends ProjectSettings {

	//Locators	
	String popUpCloseButton = "//div[contains(@class, 'ui-newuser-layer-dialog')]//a[@role='button']";
	//TODO: change to be able to select the desired page with a param
	String pageSelector = "//div[@class='next-pagination-list']//button[text()='2']";
	//TODO: change to be able to select the desired product with a param
	String productSelector = "//div[@product-index='1']";
	
	
	public SearchResultsPage switchPage() {
		
		if(driver.findElement(By.xpath(popUpCloseButton)).isDisplayed()) {
			driver.findElement(By.xpath(popUpCloseButton)).click();
		}
		
		//TODO: revise this in order to improve stability
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollBy(0, document.body.scrollHeight-2000)");
		
		//TODO: replace thread sleep with a proper wait
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
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
