package com.sdetsg.utility;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sdetsg.config.ProjectSettings;

public class Utils extends ProjectSettings {

	/**
	 * Switches between tabs to the desired tab
	 * @param desiredTab (first tab is 0)
	 */
	public static void switchTabs(int desiredTab) {
		
	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(desiredTab));
	}
	
	
	/**
	 * Tries to find the given element every 500 milliseconds for a maximum amount of time
	 * @param waitTimeInSeconds
	 * @param element
	 *
	 */
	public static boolean waitUntilElementPresent(int waitTimeInSeconds, By element) {
		
		return (new WebDriverWait(driver, java.time.Duration.ofSeconds(waitTimeInSeconds))).until(
				(ExpectedConditions.visibilityOfElementLocated(element))) != null;
				
	}
	
	/**
	 * Waits until the given element is not present by trying to find it every 500 milliseconds for a maximum amount of time
	 * @param waitTimeInSeconds
	 * @param element
	 *
	 */
	public static boolean waitUntilElementNotPresent(int waitTimeInSeconds, By element) {
		
		return (new WebDriverWait(driver, java.time.Duration.ofSeconds(waitTimeInSeconds))).until(
				(ExpectedConditions.invisibilityOfElementLocated(element))) != null;
				
	}
	
	/**
	 * Scrolls page using javascript
	 * @param x
	 * @param y
	 */
	public static void scrollPageBy(int x, int y) {
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollBy("+ x +", "+ y +")");
	}
}
