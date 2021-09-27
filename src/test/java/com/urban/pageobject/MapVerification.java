package com.urban.pageobject;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.TestRunner;

import com.urban.reusablecomponents.reusablemethods;
import com.urban.uistore.MapVerificationui;

public class MapVerification {

	public static Logger log=LogManager.getLogger( TestRunner.class.getName());
	public static void Map(WebDriver driver)
	{
		reusablemethods.click(MapVerificationui.store, driver);
		
		reusablemethods.click(MapVerificationui.place, driver);
		
		reusablemethods.click(MapVerificationui.map, driver);
	}
	
	public static String child(WebDriver driver) {
		Set<String> b=driver.getWindowHandles();
		Iterator<String> c=b.iterator();
		String parent =c.next();
		String Child =c.next();
		driver.switchTo().window(Child);
		String title=driver.getTitle();
		return title;
	}
}
