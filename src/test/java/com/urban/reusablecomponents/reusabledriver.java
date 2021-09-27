package com.urban.reusablecomponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class reusabledriver 
{
	public static WebDriver driver;
	//public static Logger logger; 
	public static WebDriver chromedriver()
	{
		String value=com.urban.utilities.Propertyfilereader.browsername();
		//logger=Logger.getLogger("UrbanLadder");
		//BasicConfigurator.configure();
		//PropertyConfigurator.configure("log4j2.properties");
		if(value.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",com.urban.utilities.Propertyfilereader.getChromePath());
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		 driver=new ChromeDriver();	
		}
		 else if(value.equalsIgnoreCase("edge"))
		   {
			   System.setProperty("webdriver.edge.driver", com.urban.utilities.Propertyfilereader.getEdge());
				 driver=new EdgeDriver();
		   }
		   else
		   {
		     System.setProperty("webdriver.gecko.driver",com.urban.utilities.Propertyfilereader.getFirefoxPath());
			 driver=new FirefoxDriver();
			
		   }
		 driver.manage().window().maximize();
		 return driver;
	}
	 public static void captureScreen(String tname) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File( ".\\Screenshots\\" + tname + ".png");
			try {
				FileUtils.copyFile(source, target);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			System.out.println("Screenshot taken");
		}	
}
