package objects;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Homepage {
	
	public static final String HOMEPAGE_URL = "https://www.humanity.com/";
	private static final String CLOSE_POPUP_XPATH = "//*[@id=\"tcp-modal\"]/div/div/div[1]/button";
    private static final String FULLNAME_BOX_XPATH = "//*[@id=\"top-form\"]/div/div[1]/input";
    private static final String WORKEMAIL_BOX_XPATH = "//*[@id=\"top-form\"]/div/div[2]/input";
    private static final String SUBMIT_BUTTON_XPATH = "//*[@id=\"free-trial-link-01\"]";
    private static final String STARTFREETRIAL_BUTTON_XPATH = "//*[@id=\"navbarSupportedContent\"]/div/a[3]";
    private static final String POPUP_FULLNAME_XPATH = "//*[@id=\"popup-form\"]/div[1]/input";
    private static final String POPUP_EMAIL_XPATH = "//*[@id=\"popup-form\"]/div[2]/input";
    private static final String POPUP_SUBMIT_XPATH = "//*[@id=\"popup-free-trial-link\"]";
    private static final String LOGIN_BTN_XPATH = "//*[@id=\"navbarSupportedContent\"]/div/a[2]/p";
    private static final String EMAIL_INPUT_XPATH = "//*[@id=\"email\"]";
    private static final String PASSWORD_INPUT_XPATH ="//*[@id=\"password\"]";
    private static final String LOGIN_SUBMIT = "/html/body/div[1]/div[2]/div/form[1]/div[3]/div/button[1]";
    
    public static void clickClosePopUp(WebDriver driver) {
    	driver.findElement(By.xpath(CLOSE_POPUP_XPATH)).click();
    }
    
    public static void inputFullName(WebDriver driver, String fullname) {
		driver.findElement(By.xpath(FULLNAME_BOX_XPATH)).sendKeys(fullname);
	}
    
    public static String randomEmail() {
		return "something" + UUID.randomUUID().toString() + "@gmail.com";
	}
    
    public static void inputWorkEmail(WebDriver driver, String workemail) {
		driver.findElement(By.xpath(WORKEMAIL_BOX_XPATH)).sendKeys(workemail);
	}
    
    public static void clickSubmitButton(WebDriver driver) {
    	driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();
    }
    
    public static void clickStartMyFreeTrialButton(WebDriver driver) {
    	driver.findElement(By.xpath(STARTFREETRIAL_BUTTON_XPATH)).click();
    }
    
    public static void inputPopupFullName(WebDriver driver, String popupfullname) {
		driver.findElement(By.xpath(POPUP_FULLNAME_XPATH)).sendKeys(popupfullname);
	}
    
    public static void inputPopupEmail(WebDriver driver, String popupemail) {
		driver.findElement(By.xpath(POPUP_EMAIL_XPATH)).sendKeys(popupemail);
	}
    
    public static void clickPopupSubmit(WebDriver driver) {
    	driver.findElement(By.xpath(POPUP_SUBMIT_XPATH)).click();
    }
    public static void clickLoginButton(WebDriver driver) {
    	driver.findElement(By.xpath(LOGIN_BTN_XPATH)).click();
    }
    public static void inputEmailUsername(WebDriver driver, String emailUser) {
		driver.findElement(By.xpath(EMAIL_INPUT_XPATH)).sendKeys(emailUser);
	}
    
    public static void inputPassword(WebDriver driver, String logPass) {
		driver.findElement(By.xpath(PASSWORD_INPUT_XPATH)).sendKeys(logPass);
	}
    public static void clickLoginSubmit(WebDriver driver) {
    	driver.findElement(By.xpath(LOGIN_SUBMIT)).click();
    }
    
}
