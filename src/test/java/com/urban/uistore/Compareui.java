package com.urban.uistore;

import org.openqa.selenium.By;

public class Compareui {
	
	public static By recom_mouseover=By.xpath("//span[contains(text(),'Recom')]");
	public static By low_to_high=By.cssSelector("[data-key='price_desc']");
	public static By firstproduct=By.cssSelector("[data-id='98114']");
	public static By secondproduct=By.cssSelector("[data-id='30865']");
	
	public static By frstcompare=By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[3]/ul/li[1]/div/div[5]/a[1]");
	
	public static By secondcompare=By.xpath("//*[@id=\"search-results\"]/div[3]/ul/li[2]/div/div[5]/a[1]");
	
	public static By compare_button=By.id("compare-cta");
	
	public static By close=By.xpath("//a[@class='close-reveal-modal close-overlay']");
	
	public static By title=By.xpath("//img[@alt='Urban Ladder - Online furniture store']");
	

}
