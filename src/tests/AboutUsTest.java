package tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.AboutUs;
import objects.Homepage;

public class AboutUsTest {
	
	private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\drive\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}	
	
	@Test
	public void goToAboutUsTest() {
		
		driver.navigate().to(AboutUs.HOMEPAGE_URL);
		driver.manage().window().fullscreen();
	    Homepage.clickClosePopUp(driver);
		AboutUs.clickAboutUsMenu(driver);
		AboutUs.clickButton(driver);
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile, new File(".\\screenshotFolder\\AboutUsScreenshot.png"));
		} catch (IOException e) {
			System.out.println("Error screenshot not taken");
			e.printStackTrace();
		}
		
		String actual = driver.getCurrentUrl();
		String expected = AboutUs.ABOUTUS_URL;
		
		Assert.assertEquals(actual, expected);
	}		
		

}
