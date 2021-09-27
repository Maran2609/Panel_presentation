package com.urban.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.TestRunner;

import com.urban.reusablecomponents.reusablemethods;
import com.urban.uistore.Count_productsui;

public class Count_products {
	
	
	public static Logger log=LogManager.getLogger( TestRunner.class.getName());
	public static void select(WebDriver driver)
	{
		reusablemethods.action(Count_productsui.kids, driver);
		
		reusablemethods.click(Count_productsui.playtables, driver);
	}

	public static int count(WebDriver driver)
	{
		int size=reusablemethods.getsize(Count_productsui.images, driver);
		return size;
	}
	public static String verify(WebDriver driver)
	{
		String text=reusablemethods.gettext(Count_productsui.verifytext, driver);
		
		return text;
	}
}
