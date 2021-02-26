package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.Homepage;
import objects.SignUpForm;

public class HomePageTest {
	
private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\drive\\ChromeDriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(priority=1)
	public void testSignupWithoutPopUp() {
		
		driver.navigate().to(Homepage.HOMEPAGE_URL);
		Homepage.clickClosePopUp(driver);
		Homepage.inputFullName(driver, "Jane Doe");
		
		String mail = Homepage.randomEmail();
		
		Homepage.inputWorkEmail(driver, mail);
		Homepage.clickSubmitButton(driver);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String actual = driver.getCurrentUrl();
		String expected = "https://www.humanity.com/wizard-setup2/";
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2)
	public void testSignUpWithPopUp() {
		
		driver.get(Homepage.HOMEPAGE_URL);
		driver.manage().window().maximize();
		
		//Homepage.clickClosePopUp(driver);
		
		Homepage.clickStartMyFreeTrialButton(driver);
		Homepage.inputPopupFullName(driver, "John Doe");
		
		String mail = Homepage.randomEmail();
		
		Homepage.inputPopupEmail(driver, mail);
		Homepage.clickPopupSubmit(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = "https://www.humanity.com/wizard-setup2/";  
		
		
		Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=3)
	public void testFillSignUpForm() {
		
		driver.navigate().to(SignUpForm.URL);
		SignUpForm.inputCompanyName(driver, "Company test");
		SignUpForm.chooseIndustry(driver);
		SignUpForm.chooseFunctionalRole(driver);
		SignUpForm.inputPhoneNumber(driver, "555555");
		SignUpForm.inputPassword(driver, "tiktok");
		SignUpForm.confirmPassword(driver, "tiktok");
		SignUpForm.clickStartScheduling(driver);
		
		String actual = driver.getCurrentUrl();
		String expected = "https://CompanyTest.humanity.com/app/schedule/employee/week/overview/overview/22%2c1%2c2021/";
		
		Assert.assertEquals(actual, expected);
	}
	


}
