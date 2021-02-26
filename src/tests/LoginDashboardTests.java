package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Dashboard;
import objects.Homepage;

public class LoginDashboardTests {
	
private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\drive\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority=1)
	public void testLogin() {
		
		driver.navigate().to(Homepage.HOMEPAGE_URL);
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
		
		String actual = driver.getCurrentUrl();
		String expected = "https://itbootcamp9.humanity.com/app/dashboard/" ;
		
		Assert.assertEquals(actual, expected);
		
	}
	@Test(priority=2)
	public void testDashboardUpperMenu() {
		
		driver.navigate().to(Dashboard.URL);
		SoftAssert sa = new SoftAssert();
		
		Dashboard.clickHumanityLogo(driver); //URL working
		sa.assertEquals(driver.getCurrentUrl(), "https://itbootcamp9.humanity.com/app/dashboard/");
		 
		Dashboard.clickDashboardBtn(driver); //URL working
		sa.assertEquals(driver.getCurrentUrl(), "https://itbootcamp9.humanity.com/app/dashboard/");
		
		Dashboard.clickShiftPlanBtn(driver);
		sa.assertEquals(driver.getTitle(), "ShiftPlanning - Humanity");
		
		Dashboard.clickTimeClockBtn(driver); //URL working
		sa.assertEquals(driver.getCurrentUrl(), "https://itbootcamp9.humanity.com/app/timeclock/");
		
		Dashboard.clickLeaveBtn(driver);  //URL working
		sa.assertEquals(driver.getCurrentUrl(), "https://itbootcamp9.humanity.com/app/requests/vacation/");
		
		
		Dashboard.clickTrainingBtn(driver);
		sa.assertEquals(driver.getTitle(), "Training - Overview - Humanity");
		
		Dashboard.clickStaffBtn(driver);
		sa.assertEquals(driver.getTitle(), "Staff - Humanity");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Dashboard.clickAvailabilityBtn(driver); //takes too long to load, sometimes payroll and reports tests fail because of it
		sa.assertEquals(driver.getTitle(), "Humanity");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Dashboard.clickPayrollBtn(driver); //sometimes works with id and xpath, but sometimes neither of them
		sa.assertEquals(driver.getTitle(), "Payroll - Scheduled-hours - Humanity");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Dashboard.clickReportsBtn(driver); //same as payroll button
		sa.assertEquals(driver.getTitle(), "Reports - Reports Home - Humanity");
		
		sa.assertAll();
	}


}
