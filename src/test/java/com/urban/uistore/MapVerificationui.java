package com.urban.uistore;

import org.openqa.selenium.By;

public class MapVerificationui {

	public static By store=By.xpath("//ul[@class='featuredLinksBar__linkContainer']/li/a[contains(@href,'furniture-stores')]");
	public static By place=By.xpath("//h3[contains(text(),'Nungam')]");
	public static By map=By.xpath("//a[@data-gaaction='click_view_map']");
}
