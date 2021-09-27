package com.urban.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.TestRunner;

import com.urban.reusablecomponents.reusablemethods;
import com.urban.uistore.Search_verifyui;

public class Search_verify {
	public static Logger log=LogManager.getLogger( TestRunner.class.getName());
	
	public static void search(String name,WebDriver driver)
    {
    	reusablemethods.click(Search_verifyui.search_box, driver);
    	reusablemethods.sendkeys(Search_verifyui.search_box, name, driver);
    	reusablemethods.enter(Search_verifyui.search_box, driver);
    	
    }

	public static String verify(WebDriver driver)
	{
		String text=reusablemethods.gettext(Search_verifyui.verify, driver);
		return text;
	}
}
