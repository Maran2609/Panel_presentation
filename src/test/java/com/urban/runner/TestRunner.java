package com.urban.runner;


import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.urban.pageobject.Add_to_cart;
import com.urban.pageobject.Compare;
import com.urban.pageobject.Count_products;
import com.urban.pageobject.Homepage;
import com.urban.pageobject.MapVerification;
import com.urban.pageobject.Playstore;
import com.urban.pageobject.Price;
import com.urban.pageobject.ReturningHomepage;
import com.urban.pageobject.Search_verify;
import com.urban.pageobject.Wishlist;
import com.urban.reusablecomponents.reusabledriver;
import com.urban.reusablecomponents.reusablemethods;
import com.urban.utilities.ExcelReader;
import com.urban.utilities.Propertyfilereader;
import com.urban.utilities.logger;

public class TestRunner extends reusabledriver {

	public static Logger log=LogManager.getLogger( TestRunner.class.getName());
	
	
	@BeforeMethod
	public void openbrowser() throws InterruptedException
	{
		try {
		reusabledriver.chromedriver();
		reusablemethods.loadurl(driver);
		reusablemethods.timelapse(driver);
		log.info("URL Loaded");
		}catch(Exception e) {
			logger.loginfo( log,"Browser not loaded");
			reusabledriver.captureScreen("Browser Not Loaded");
		}

	}
	@Test(priority=0)
	public void Homepage() throws InterruptedException
	{
		try {
		Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));

		System.out.println("Login Successfull");
		log.info("Login");
		}catch(Exception e) {
			logger.loginfo(log,"Cannot Login");
		reusabledriver.captureScreen("Login");
		}
	}

	@Test(priority=3,dataProvider="getexceldata")
	public void search_and_verify(String name) throws InterruptedException
	{
		
		//homepage();
		try {
		Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
		Search_verify.search(name,driver);
		String text=Search_verify.verify(driver);
		if(text.contains("Search Results For "))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		System.out.println("Verified");
		logger.loginfo(log, "Successfully Searched the Product");
		}catch(Exception e)
		{
			logger.loginfo(log, "Cannot Search the Product");
			reusabledriver.captureScreen("SearchError");
		}
		
	}
	@Test(dataProvider="data",priority=2)
	public void Add_cart(String product,String name) throws InterruptedException
	{
		
		//homepage();
		try {
		Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
		Add_to_cart.search(driver, product);
		Add_to_cart.click_product(driver, name);
		Add_to_cart.child(driver);
		Add_to_cart.adding_cart(driver);
		String text=Add_to_cart.verify(driver);
		//driver.close();
		Assert.assertEquals(text, "CHECKOUT");
		
		System.out.println("Added to Cart");
		logger.loginfo(log, "Successfully Added the product");
		}
		catch(Exception e)
		{
			logger.loginfo(log, "Cannot Add the Product");
			reusabledriver.captureScreen("Addtocart Error");
		}
		
		
	}
	
	@Test(priority=1)
	public void Compare_products() throws InterruptedException
	{
		try {
		Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
		Compare.search(driver,"sofa");
		Compare.compare(driver);
		
		Boolean text=Compare.verify(driver);
		Assert.assertTrue(text);
		System.out.println("Verified");
		logger.loginfo(log, "Compared Successfully");
		}
		catch(Exception e)
		{
			logger.loginfo(log, "Cannot Compare");
			reusabledriver.captureScreen("Compare Error");
		}
	}
	
	@Test(priority=7)
	public void Printprice() throws InterruptedException
	{
		try {
		Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
		Price.search(driver, "Cel Laptop Table");
		Price.click_product(driver, "Cel Laptop Table");
		Price.child(driver);
		String price=Price.get_price(driver);
		System.out.println("Price "+price);
		logger.loginfo(log, "Price"+price);
		}
		catch(Exception e)
		{
			logger.loginfo(log, "Not able to Print");
			reusabledriver.captureScreen("Printing Error");
		}
		
	}
	
	@Test(priority=6)
	public void ReturningHome() throws InterruptedException
	
	
	{
		try {
		Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
		ReturningHomepage.wooden(driver);
		
		ReturningHomepage.selecttrack(driver);
		
		Boolean value=ReturningHomepage.home(driver);
		
		Assert.assertTrue(value);
		System.out.println("Successfully Returned HomePage");
		logger.loginfo(log, "Successfully Returned");
		}
		catch(Exception e)
		{
			logger.loginfo(log, "Not Returned Homepage");
			reusabledriver.captureScreen("Returning Error");
		}
	}	

	@Test(priority=5)
	public void Wishlist_product() throws InterruptedException
	{
		try {
		Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
		Wishlist.search(driver, "Cel Laptop Table");
		Wishlist.click_product(driver, "Cel Laptop Table");
		
		Wishlist.child(driver);
		Boolean value=Wishlist.add_wish(driver);
		Assert.assertTrue(value);
		System.out.println("Product Wishlisted");
		logger.loginfo(log, "Added to Wishlisted");
		}catch(Exception e)
		{
			reusabledriver.captureScreen("Not Added to Wishlist");
			logger.loginfo(log, "Error in Wishlist");
		}
		
	}

	@Test(priority=4)
	public void Counting() throws InterruptedException
	{
		try {
		Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
		Count_products.select(driver);
		int Nos=Count_products.count(driver);
		String value=Integer.toString(Nos);
		//System.out.println(value);
		String verifytext=Count_products.verify(driver);
		//System.out.println(verifytext);
		if(verifytext.contains(value))
		{
			Assert.assertTrue(true);
		}
		logger.loginfo(log, "Counted Successfully");
		}catch(Exception e)
		{
			logger.loginfo(log, "Not Counted");
			reusabledriver.captureScreen("Counting Error");
		}
	}

	@Test(priority=8)
	public void Mapverification() throws InterruptedException 
	{
		try {
		Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
		MapVerification.Map(driver);
		
		String title=MapVerification.child(driver);
		//System.out.println(title);
		if(title.contains("Google"))
		{
			Assert.assertTrue(true);
		}
		else {
		Assert.assertTrue(false);
		}
		logger.loginfo(log, "Map verified Successfully");
		}
		catch(Exception e)
		{
			reusabledriver.captureScreen("Map Error");
			logger.loginfo(log, "Not Verified");
		}
		
	}
		
	
	@Test(priority=9)
	public void playstoreVerification() throws InterruptedException
	
	{
		try {
		Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
		Playstore.playstoreverfication(driver);
		Playstore.child(driver);
		boolean value=Playstore.verify(driver);
		Assert.assertTrue(value);
		System.out.println("Landed on Playstore");
		logger.loginfo(log, "Successfully Landed on Playstore");
		}catch(Exception e)
		{
			logger.loginfo(log, "Not Landed on Playstore");
			reusabledriver.captureScreen("PlaystoreError");
		}
	}
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
		
	}
	@DataProvider
	public Object[][] data() throws IOException
	{
		Object[][] data=ExcelReader.getexceldata(Propertyfilereader.getSheetName());
		return data;
	}
	@DataProvider
	public Object[][] getexceldata() throws IOException{
	ExcelReader d=new ExcelReader();
	ArrayList<String> data= d.getData("Bed");
	int s=data.size();
	Object[][] searchdata=new Object[s][1];
	for(int i=0;i<s;i++) {
	searchdata[i][0]=data.get(i);
	}
	return searchdata;

	}
}
