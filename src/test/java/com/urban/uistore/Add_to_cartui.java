package com.urban.uistore;

import org.openqa.selenium.By;

public class Add_to_cartui {
	
	public static By bookshelves=By.cssSelector("a[href='/bookshelf?src=explore_categories']");
	public static By book=By.xpath("//span[contains(text(),'Alberto Bookshelf/Display Unit ')]");
	public static By product_name=By.cssSelector("[itemprop=\"name\"]");
	public static By cart=By.cssSelector("[data-galabel='add to cart']");
	
	public static By checkout=By.cssSelector("#checkout-link");
	

}
