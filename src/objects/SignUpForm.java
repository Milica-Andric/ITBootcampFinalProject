package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpForm {
	
	public static final String URL = "https://www.humanity.com/wizard-setup2/";
	private static final String INPUT_COMPANY_NAME_XPATH = "//*[@id=\"root\"]/div/div/form/div[1]/div/div[1]/div/div/input";
	private static final String INDUSTRY_DROPDOWN_XPATH = "/html/body/div/div/div/form/div[1]/div/div[2]/div/div/span";
	private static final String FUNCTINAL_ROLE_XPATH = "/html/body/div/div/div/form/div[1]/div/div[3]/div/div/span";
	private static final String PHONE_XPATH = "//*[@id=\"root\"]/div/div/form/div[1]/div/div[4]/div/input";
	private static final String PASSWORD_XPATH = "//*[@id=\"root\"]/div/div/form/div[1]/div/div[5]/div/input";
    private static final String CONFIRM_PASSWORD_XPATH = "/html/body/div/div/div/form/div[1]/div/div[6]/div/input";
    private static final String START_SCHEDULING_XPATH = "/html/body/div/div/div/form/div[2]/span/input";
   
    public static void inputCompanyName(WebDriver driver, String companyName) {
		driver.findElement(By.xpath(INPUT_COMPANY_NAME_XPATH)).sendKeys(companyName);
	}
    public static void chooseIndustry(WebDriver driver) {
    	WebElement industry = driver.findElement(By.xpath(INDUSTRY_DROPDOWN_XPATH));
        industry.click();
        industry.sendKeys(Keys.ARROW_DOWN);
        industry.sendKeys(Keys.ARROW_DOWN); 
        industry.sendKeys(Keys.ENTER);
    }
    public static void chooseFunctionalRole(WebDriver driver) {
    	WebElement role = driver.findElement(By.xpath(FUNCTINAL_ROLE_XPATH));
        role.click();
        role.sendKeys(Keys.ARROW_DOWN);
        role.sendKeys(Keys.ENTER);
    }
    public static void inputPhoneNumber(WebDriver driver, String phone) {
		driver.findElement(By.xpath(PHONE_XPATH)).sendKeys(phone);
	}
    public static void inputPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(PASSWORD_XPATH)).sendKeys(password);
	}
    public static void confirmPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(CONFIRM_PASSWORD_XPATH)).sendKeys(password);
	}
    public static void clickStartScheduling(WebDriver driver) {
    	driver.findElement(By.xpath(START_SCHEDULING_XPATH)).click();
	}
    
    
    
    
}
