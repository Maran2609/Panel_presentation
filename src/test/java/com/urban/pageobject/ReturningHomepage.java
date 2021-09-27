package com.urban.pageobject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.TestRunner;

import com.urban.reusablecomponents.reusablemethods;
import com.urban.uistore.Add_to_cartui;
import com.urban.uistore.Compareui;
import com.urban.uistore.ReturningHomepageui;
import com.urban.uistore.Search_verifyui;

public class ReturningHomepage {
	public static Logger log=LogManager.getLogger( TestRunner.class.getName());
	
	public static void wooden(WebDriver driver)
	{
		reusablemethods.action(ReturningHomepageui.Living, driver);
		reusablemethods.click(ReturningHomepageui.chair, driver);
	}


	public static void selecttrack(WebDriver driver)
	{
		reusablemethods.click(ReturningHomepageui.track, driver);
	}
	public static boolean home(WebDriver driver) {
		reusablemethods.click(ReturningHomepageui.home, driver);
		
		reusablemethods.display(ReturningHomepageui.profile, driver);
		
		return true;
	}
	
}
