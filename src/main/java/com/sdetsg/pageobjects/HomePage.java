package com.sdetsg.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import com.sdetsg.config.ProjectSettings;
import com.sdetsg.utility.Utils;

public class HomePage extends ProjectSettings {

	// Locators
	By promoIframe = By.xpath("//iframe[contains(@src, 'campaign.aliexpress.com')]");
	By popUpCloseButton = By.xpath("//img[@class='rax-image ' and contains(@src, 'TB1a')]");
	By searchInput = By.xpath("//input[@id='search-key']");
	By searchButton = By.xpath("//input[@class='search-button']");

	/**
	 * Maximizes the browser and navigates to the given URL
	 * @param url
	 */
	public HomePage goToHomePage(String url) {

		driver.manage().window().maximize();
		driver.get(url);

		return new HomePage();
	}

	/**
	 * Closes the promo popup if present
	 */
	public HomePage closePromoPopUpIfPresent() {

		/**
		 * There's no need to close this popup here since I can write in the input without closing it
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

			System.out.println("Promo popup was not present at home page");
		}

		return new HomePage();
	}
	
	/**
	 * Searches for the given product
	 * @param product
	 */
	public SearchResultsPage searchProduct(String product) {

		driver.findElement(searchInput).sendKeys(product);
		driver.findElement(searchButton).click();

		/**
		 * An alternative here could be to use enter right after entering the product to
		 * search and not use the click on the search button:
		 * driver.findElement(By.xpath(searchInput)).sendKeys(product, Keys.ENTER);
		 */

		return new SearchResultsPage();
	}
}
