package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Settings {
	
	private static final String SETTINGS_BTN_XPATH = "//*[@id=\"sn_admin\"]/span";
	//private static final String CHECKBOX_EMAIL_XPATH = "//*[@id=\"pref_pref_email\"]";
	//private static final String CHECKBOX_SMS_XPATH = "//*[@id=\"pref_pref_sms\"]";
	//private static final String CHECKBOX_MOBILEPUSH_XPATH = "//*[@id=\"pref_pref_mobile_push\"]";
	private static final String SAVESETTINGS_BTN_XPATH = "//*[@id=\"act_primary\"]";
	
	public static void clickSettingsBtn(WebDriver driver) {
    	driver.findElement(By.xpath(SETTINGS_BTN_XPATH)).click();
    }
	public static void chooseLangugage(WebDriver driver) {
		WebElement lang = driver.findElement(By.name("language"));
		lang.click();
		lang.sendKeys(Keys.ARROW_DOWN);
        lang.sendKeys(Keys.ARROW_DOWN);
        lang.sendKeys(Keys.ENTER);
    }
	
	public static void clickSaveSettings(WebDriver driver) {
    	driver.findElement(By.xpath(SAVESETTINGS_BTN_XPATH)).click();
    }
	
	public static void checkboxEmail(WebDriver driver) {
		driver.findElement(By.id("pref_pref_email")).click();
	}
	public static void checkboxSMS(WebDriver driver) {
		driver.findElement(By.id("pref_pref_sms")).click();
	}
	public static void checkboxMobile(WebDriver driver) {
		driver.findElement(By.id("pref_pref_mobile_push")).click();
	}
	
	

}
