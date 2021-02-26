package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard {
	
	public static final String URL = "https://itbootcamp9.humanity.com/app/dashboard/";
	private static final String HUMANITY_LOGO_XPATH = "//*[@id=\"_nav\"]/div[1]/img";
	private static final String DASHBOARD_BTN_XPATH = "//*[@id=\"sn_dashboard\"]/span";
	private static final String SHIFTPLANNING_BTN_XPATH = "//*[@id=\"sn_schedule\"]/span";
	private static final String TIMECLOCK_BTN_XPATH = "//*[@id=\"sn_timeclock\"]/span";
	private static final String LEAVE_BTN_XPATH = "//*[@id=\"sn_requests\"]/span";
	private static final String TRAINING_BTN_XPATH = "//*[@id=\"sn_training\"]/span";
	private static final String STAFF_BTN_XPATH = "//*[@id=\"sn_staff\"]";
	private static final String AVAILABILITY_BTN_XPATH = "//*[@id=\"sn_availability\"]/span";
	
	private static final String PAYROLL_BTN_XPATH = "//*[@id=\"sn_payroll\"]/span";
	private static final String REPORTS_BTN_XPATH = "//*[@id=\"root\"]/div[2]/div/div/div[1]/div/div/div[2]/div[9]/a";
	
	
	public static void clickHumanityLogo(WebDriver driver) {
    	driver.findElement(By.xpath(HUMANITY_LOGO_XPATH)).click();
    }
	
	public static void clickDashboardBtn(WebDriver driver) {
    	driver.findElement(By.xpath(DASHBOARD_BTN_XPATH)).click();
    }
	public static void clickShiftPlanBtn(WebDriver driver) {
    	driver.findElement(By.xpath(SHIFTPLANNING_BTN_XPATH)).click();
    }
	
	public static void clickTimeClockBtn(WebDriver driver) {
    	driver.findElement(By.xpath(TIMECLOCK_BTN_XPATH)).click();
    }
	
	public static void clickLeaveBtn(WebDriver driver) {
    	driver.findElement(By.xpath(LEAVE_BTN_XPATH)).click();
    }
	
	public static void clickTrainingBtn(WebDriver driver) {
    	driver.findElement(By.xpath(TRAINING_BTN_XPATH)).click();
    }
	public static void clickStaffBtn(WebDriver driver) {
    	driver.findElement(By.xpath(STAFF_BTN_XPATH)).click();
    }
	
	public static void clickAvailabilityBtn(WebDriver driver) {
    	driver.findElement(By.xpath(AVAILABILITY_BTN_XPATH)).click();
    }
	public static void clickPayrollBtn(WebDriver driver) {
    	driver.findElement(By.xpath(PAYROLL_BTN_XPATH)).click();
    }
	public static void clickReportsBtn(WebDriver driver) {
    	driver.findElement(By.xpath(REPORTS_BTN_XPATH)).click();
    }


}
