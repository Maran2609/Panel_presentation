package com.urban.uistore;

import org.openqa.selenium.By;

public class Wishlistui {
	
	public static By study=By.cssSelector(".topnav_item.studyunit");
	
	public static By study_lamp=By.cssSelector("[href='/study-lamps?src=g_topnav_study_study-lamps_study-lamps']");
	
	
	public static By recom_mouseover=By.xpath("//span[contains(text(),'Recom')]");
	public static By new_arrival=By.cssSelector("[data-key='new_arrival']");
	
	public static By select=By.xpath("//span[contains(text(),'Kaira Study Lamp ')]");
	public static By product_name=By.cssSelector("[itemprop=\"name\"]");
	
	public static By wishtext=By.cssSelector(".wishtext");
	
	public static By verify=By.cssSelector("[class='icofont wishicon icofont-heart_fill selected']");
	

}
