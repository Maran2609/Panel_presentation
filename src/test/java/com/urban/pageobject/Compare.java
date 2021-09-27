package com.urban.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestRunner;

import com.urban.reusablecomponents.reusablemethods;
import com.urban.uistore.Compareui;
import com.urban.uistore.Search_verifyui;

public class Compare {
	public static Logger log=LogManager.getLogger( TestRunner.class.getName());
	
	public static void search(WebDriver driver,String product) {
		
	    	reusablemethods.click(Search_verifyui.search_box, driver);
	    	reusablemethods.sendkeys(Search_verifyui.search_box,product, driver);
	    	reusablemethods.enter(Search_verifyui.search_box, driver);
	    	
	    }
	
	public static void compare(WebDriver driver)
	{
		reusablemethods.action(Compareui.recom_mouseover, driver);
		reusablemethods.actionclick(Compareui.low_to_high, driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Compareui.firstproduct));
		reusablemethods.action(Compareui.firstproduct, driver);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Compareui.firstproduct));
		reusablemethods.click(Compareui.frstcompare, driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Compareui.secondproduct));
		reusablemethods.action(Compareui.secondproduct, driver);
		reusablemethods.actionclick(Compareui.secondcompare, driver);
		
		
		//reusablemethods.click(Compareui.close, driver);
		reusablemethods.click(Compareui.compare_button, driver);
		
	}
	
	public static boolean verify(WebDriver driver) {
		Boolean text=reusablemethods.display(Compareui.title, driver);
		return text;
		
	}
	}



