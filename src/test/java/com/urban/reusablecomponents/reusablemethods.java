package com.urban.reusablecomponents;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;



public class reusablemethods 
{

	public static void loadurl(WebDriver driver)
	{
		driver.get(com.urban.utilities.Propertyfilereader.loadurl());	
	}
	
	public static void timelapse(WebDriver driver) {
		int wait = Integer.parseInt(com.urban.utilities.Propertyfilereader.propfile().getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}
   public static String gettext(By selector, WebDriver driver)
   {
	   try
	   {
	   String text=driver.findElement(selector).getText();
	   return text;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return "false";
	   }  
   }
   public static boolean enter(By selector, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).sendKeys(Keys.ENTER);
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return false;
	   }    
   }
   public static boolean clear(By selector, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).clear();
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return false;
	   }    
   }
   public static boolean sendkeys(By selector, String value, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).sendKeys(value);
	  return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		  return false;
	   }
	   
   }
   public static boolean click(By selector, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).click();
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return false;
	   }
	   
   }
   public static boolean action(By selector, WebDriver driver)
   {
	   Actions act=new Actions(driver);
	   try
	   {
	   act.moveToElement(driver.findElement(selector)).build().perform();
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return false;
	   }    
   }
   public static boolean actionclick(By selector, WebDriver driver)
   {
	   Actions act=new Actions(driver);
	   try
	   {
	   act.moveToElement(driver.findElement(selector)).click().build().perform();
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return false;
	   }    
   }
   public static boolean display(By selector, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).isDisplayed();
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return false;
	   }    
   }
   public static int getsize(By selector, WebDriver driver)
   {
	   try
	   {
	   int size=(driver.findElements(selector).size());
	   return size;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return 0;
	   }  
   }
   
   public static boolean closebrowser(WebDriver driver)
   {
	   try
	   {
	   driver.quit();
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element doesnt exist"));
		   return false;
	   }    
   }



  
	
	
	
	
}
