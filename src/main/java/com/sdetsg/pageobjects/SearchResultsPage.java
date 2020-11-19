package com.sdetsg.pageobjects;
import com.sdetsg.config.ProjectSettings;

public class SearchResultsPage extends ProjectSettings {

	//Locators	
	String popUpCloseButton = "//div[contains(@class, 'ui-newuser-layer-dialog')]//a[@role='button']";
	String pageSelector = "//div[@class='next-pagination-list']//button[text()='2']";
	String productSelector = "//div[@product-index='1']";
	
}
