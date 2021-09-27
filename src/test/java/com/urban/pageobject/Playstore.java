package com.urban.pageobject;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.TestRunner;

import com.urban.reusablecomponents.reusablemethods;
import com.urban.uistore.Playstoreui;

public class Playstore {
	public static Logger log=LogManager.getLogger( TestRunner.class.getName());
	public static void playstoreverfication(WebDriver driver)
	{
		reusablemethods.click(Playstoreui.logo, driver);
		
		
	}

	public static void child(WebDriver driver) {
		Set<String> b=driver.getWindowHandles();
		Iterator<String> c=b.iterator();
		String parent =c.next();
		String Child =c.next();
		driver.switchTo().window(Child);
		
	}
	public static boolean verify(WebDriver driver)
	{
		boolean value=reusablemethods.display(Playstoreui.playstorelogo, driver);
		return value;
	}

}
