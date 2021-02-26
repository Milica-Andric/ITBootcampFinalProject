package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Dashboard;
import objects.Homepage;
import objects.Settings;

public class SettingsTests {
	
private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\drive\\ChromeDriver.exe");
		driver = new ChromeDriver();
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

	}
	
	@Test(priority=1)
	public void testChangeLanguage() {
		
		driver.navigate().to(Homepage.HOMEPAGE_URL); //first log in
		driver.manage().window().maximize();
		Homepage.clickClosePopUp(driver);
		Homepage.clickLoginButton(driver);
		Homepage.inputEmailUsername(driver, "comili@gmail.com"); //using a profile created manually
		Homepage.inputPassword(driver, "mikmik");
		Homepage.clickLoginSubmit(driver);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Settings.clickSettingsBtn(driver);
		//Settings.chooseLangugage(driver);
		
		
		WebElement lang = driver.findElement(By.name("language"));
        Select sel = new Select(lang);
        sel.selectByVisibleText("Croatian (machine)");
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.id("_save_settings_button")).click();
		driver.navigate().refresh();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Dashboard.clickTimeClockBtn(driver);
		WebElement addClockTimeBtn = driver.findElement(By.xpath("//*[@id=\"_cd_timeclock\"]/div[1]/div/div/ul[1]/li[2]/a"));
		String actual = addClockTimeBtn.getText().toString();
		
		Assert.assertEquals(actual, "Dodajte sat vremena");
	   
	}
	@Test(priority=2)
	public void testDisableNotifications() {
		
		Settings.clickSettingsBtn(driver);
		
		SoftAssert sa = new SoftAssert();
		
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		Settings.checkboxEmail(driver);
		Settings.checkboxSMS(driver);
		Settings.checkboxMobile(driver);
		Settings.clickSaveSettings(driver);
		driver.navigate().refresh();
		
		WebElement checkbox1 = driver.findElement(By.id("pref_pref_email"));
		boolean actual = checkbox1.isSelected();
		sa.assertEquals(actual, true);
		
		WebElement checkbox2 = driver.findElement(By.id("pref_pref_sms"));
		boolean actual2 = checkbox2.isSelected();
		sa.assertEquals(actual2, true);
		
		WebElement checkbox3 = driver.findElement(By.id("pref_pref_mobile_push"));
		boolean actual3 = checkbox3.isSelected();
		sa.assertEquals(actual3, true);
		
		sa.assertAll();
		
	}

}
