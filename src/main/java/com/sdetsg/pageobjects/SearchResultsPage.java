package com.sdetsg.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import com.sdetsg.config.ProjectSettings;
import com.sdetsg.utility.Utils;

public class SearchResultsPage extends ProjectSettings {

	//Locators	
	By popUpCloseButton = By.xpath("//div[contains(@class, 'ui-newuser-layer-dialog')]//a[@role='button']");
	public By pageSelector(int pageNumber) { return By.xpath("//div[@class='next-pagination-list']//button[text()='"+ pageNumber +"']"); }
	public By productSelector(int productNumber) { return By.xpath("//div[@product-index='"+ productNumber +"']"); }
	By overlay = By.xpath("//div[@class='next-overlay-wrapper']");
		
	/**
	 * Switches to the given page number
	 * @param pageNumber
	 */
	public SearchResultsPage switchPage(int pageNumber) {
		
		try {
			if (Utils.waitUntilElementPresent(10, popUpCloseButton)) {

				driver.findElement(popUpCloseButton).click();
			}
		} catch (TimeoutException e) {

			System.out.println("Promo popup was not present at search results page");
		}
		
		for(int i = 0 ; i < 10000 ; i = i + 1000) {
			try {
				if(Utils.waitUntilElementNotPresent(2, pageSelector(pageNumber))) {
					Utils.scrollPageBy(0, 1000);
					Thread.sleep(500);
				} 
			} catch (Exception e) {
				i = 10000;
			}
		}

		driver.findElement(pageSelector(pageNumber)).click();
				
		return new SearchResultsPage();
	}
	
	/**
	 * Clicks on the given product
	 * @param productNumber (first product is 0)
	 */
	public SingleProductPage accessProduct(int productNumber) {
		
		try {
			Utils.waitUntilElementPresent(5, overlay);
			Utils.waitUntilElementNotPresent(5, overlay);
		} catch (TimeoutException e) {
			System.out.println("Overlay not found while switching pages");
		}
				
		driver.findElement(productSelector(productNumber)).click();
		
		return new SingleProductPage();
	}
}
