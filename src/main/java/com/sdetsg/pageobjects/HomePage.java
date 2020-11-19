package com.sdetsg.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.sdetsg.config.ProjectSettings;

public class HomePage extends ProjectSettings {
	 
	//Locators
	String popUpCloseButton = "//img[@class='rax-image ' and @data-spm-anchor-id]";
	String searchInput = "//input[@id='search-key']";
	String searchButton = "//input[@class='search-button']";
	

	public HomePage goToHomePage(String url) {
		
		driver.manage().window().maximize();
		driver.get(url);
		
		//TODO: figure out a way to close the popup
		if(driver.findElement(By.xpath(searchInput)).isDisplayed()) {
			//driver.findElement(By.xpath(popUpCloseButton)).click();
		}
		
		return new HomePage();
	}
	
	
	public SearchResultsPage searchProduct(String product) {
		
		driver.findElement(By.xpath(searchInput)).sendKeys(product, Keys.ENTER);
		//TODO: use click on the search button after closing popup
		//driver.findElement(By.xpath(searchButton)).click();
		
		return new SearchResultsPage();
	}
}
