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
import com.urban.uistore.Priceui;
import com.urban.uistore.Search_verifyui;

public class Price {
	public static Logger log=LogManager.getLogger( TestRunner.class.getName());
	public static void search(WebDriver driver,String product) {
		
    	reusablemethods.click(Search_verifyui.search_box, driver);
    	reusablemethods.sendkeys(Search_verifyui.search_box,product, driver);
    	reusablemethods.enter(Search_verifyui.search_box, driver);
    	
    }

	public static void click_product(WebDriver driver,String value) {
		//reusablemethods.click(Priceui.prod, driver);
		List<WebElement>products_list =driver.findElements(Add_to_cartui.product_name);
	    for(int i=0;i<products_list.size();i++)
	    {
	    	String name=driver.findElements(Add_to_cartui.product_name).get(i).getText();
	    	//System.out.println(name);
	    	if(name.equals(value))
	    	{
	    		System.out.println("valid "+ name);
	    		driver.findElements(Add_to_cartui.product_name).get(i).click();
	    		break;
	    	}
	}
	}

	public static String get_price(WebDriver driver)
	{
		String text=reusablemethods.gettext(Priceui.price, driver);
		
		return text;
	}
	
	public static void child(WebDriver driver) {
		Set<String> b=driver.getWindowHandles();
		Iterator<String> c=b.iterator();
		String parent =c.next();
		String Child =c.next();
		driver.switchTo().window(Child);
		System.out.println(driver.getTitle());
	}
}
