package com.sdetsg.utility;
import java.util.ArrayList;

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
}
