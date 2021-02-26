package objects;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewEmployees {
	
	private static final String ADD_EMPLOYEE_BTN_XPATH = "//*[@id=\"act_primary\"]";
	private static final String INPUT_EMPLOYEE_NAME_XPATH = "//*[@id=\"_asf1\"]";
	private static final String INPUT_EMPLOYEE_LASTNAME_XPATH = "//*[@id=\"_asl1\"]";
	private static final String INPUT_EMPLOYEE_EMAIL_XPATH = "//*[@id=\"_ase1\"]";
	//private static final String SAVE_EMPLOYEE_BTN_XPATH = "//*[@id=\"_as_save_multiple\"]";
	private static final String CLOSE_POPUP_XPATH = "//*[@id=\"intercom-container\"]/div/div/div/div/div/div[2]";
	
	public static void clickAddEmployee(WebDriver driver) {
    	driver.findElement(By.xpath(ADD_EMPLOYEE_BTN_XPATH)).click();
    }
	public static void inputEmployeeName(WebDriver driver, String name) {
    	driver.findElement(By.xpath(INPUT_EMPLOYEE_NAME_XPATH)).sendKeys(name);
    }
	public static void inputEmployeeLastName(WebDriver driver, String lastname) {
    	driver.findElement(By.xpath(INPUT_EMPLOYEE_LASTNAME_XPATH)).sendKeys(lastname);
    }
	public static void inputEmployeeEmail(WebDriver driver, String email) {
    	driver.findElement(By.xpath(INPUT_EMPLOYEE_EMAIL_XPATH)).sendKeys(email);
    }
	public static void clickSaveEmployee(WebDriver driver) {
    	driver.findElement(By.id("_as_save_multiple")).click();
    }
	
	public static String randomName() {
		return UUID.randomUUID().toString();
	}
	public static void clickClosePopupButton(WebDriver driver) {
    	driver.findElement(By.xpath(CLOSE_POPUP_XPATH)).click();
    }

}
