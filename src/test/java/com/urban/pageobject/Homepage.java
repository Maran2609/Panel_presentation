package com.urban.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestRunner;

import com.urban.reusablecomponents.reusablemethods;
import com.urban.uistore.Homepageui;

public class Homepage {
	public static Logger log=LogManager.getLogger( TestRunner.class.getName());
	public static void login_page(WebDriver driver, String email_id, String password) throws InterruptedException
    {
    	//Thread.sleep(10000);
    	//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-gaaction='popup.auth.close']")));
    	reusablemethods.click(Homepageui.log_in, driver);
    	//reusablemethods.click(Homepageui.email_box, driver);
    	reusablemethods.sendkeys(Homepageui.email_box, email_id, driver);
    	reusablemethods.click(Homepageui.password_box, driver);
    	reusablemethods.sendkeys(Homepageui.password_box, password, driver);
    	reusablemethods.click(Homepageui.login_button, driver);
    }
	
}
