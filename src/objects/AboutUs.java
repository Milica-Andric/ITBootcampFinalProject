package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutUs {
	
	public static final String HOMEPAGE_URL = "https://www.humanity.com/";
	private static final String ABOUTUS_MENU_XPATH = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a";
	public static final String ABOUTUS_URL = "https://www.humanity.com/about";
	private static final String ABOUTUS_XPATH = "//*[@id=\"navbarSupportedContent\"]/ul/li[6]/ul/li[1]/a";
	
	public static void clickAboutUsMenu(WebDriver driver) {
		driver.findElement(By.xpath(ABOUTUS_MENU_XPATH)).click();
	}
	public static void clickButton(WebDriver driver) {
		driver.findElement(By.xpath(ABOUTUS_XPATH)).click();
	}
	
}
