package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Dashboard;
import objects.Homepage;
import objects.NewEmployees;

public class NewEmployeesTests {
	
private static WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\drive\\ChromeDriver.exe");
		driver = new ChromeDriver();
		driver. manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	

	}
	
	@Test(priority=1)
	public void testAddingOneEmployee() throws InterruptedException {
		
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
		
		driver.navigate().to(Dashboard.URL);
		Dashboard.clickStaffBtn(driver);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		NewEmployees.clickAddEmployee(driver);
		

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		NewEmployees.inputEmployeeName(driver, "Kim");
		NewEmployees.inputEmployeeLastName(driver, "Kaynes");
		
		String mail = Homepage.randomEmail();
		
		NewEmployees.inputEmployeeEmail(driver, mail);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		NewEmployees.clickSaveEmployee(driver);
		
		
	    Thread.sleep(500);
		
		WebElement alert1 = driver.findElement(By.id("_status"));
		Assert.assertTrue(alert1.isDisplayed());
		
	}
	
	@Test(priority=2)
	public void testChangeEmployeesName()  {
				
		driver.findElement(By.xpath("//*[@id=\"sn_staff\"]/span")).click(); //click on the button stuff
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//*[@id=\'7\']/a")).click(); //click on the employee
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@id=\"_cd_staff\"]/div[2]/div[2]/div[1]/a[2]")).click(); //click on edit btn
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		String original = driver.findElement(By.id("first_name")).getAttribute("value");
		driver.findElement(By.id("first_name")).clear();
		
		driver.findElement(By.id("first_name")).sendKeys(NewEmployees.randomName());  //generating new random name
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String changed = driver.findElement(By.id("first_name")).getAttribute("value");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		driver.findElement(By.name("update")).click();
		driver.navigate().refresh();
		
		Assert.assertNotEquals(original, changed);
	}
	
	@Test(priority=3)
	public void testAddFiveEmployees() throws InterruptedException {  //via excel table created manually
				
	File f = new File("data.xlsx"); 
	try {
		InputStream inp = new FileInputStream(f); 
		XSSFWorkbook wb = new XSSFWorkbook(inp); 
		Sheet sheet = wb.getSheetAt(0); 
		
		SoftAssert sa = new SoftAssert();
		
		for(int i = 0; i < 5 ; i++) {
			Row row = sheet.getRow(i);
			
			Cell c1 = row.getCell(0);
			Cell c2 = row.getCell(1);
		   	
			String name = c1.toString(); 
			String lastName = c2.toString();
			
			driver.navigate().to(Dashboard.URL);
			Dashboard.clickStaffBtn(driver);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
						
			NewEmployees.clickAddEmployee(driver);
			NewEmployees.inputEmployeeName(driver, name);
			NewEmployees.inputEmployeeLastName(driver, lastName);
			
			String mail = Homepage.randomEmail();
			NewEmployees.inputEmployeeEmail(driver, mail);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
			NewEmployees.clickSaveEmployee(driver);
			
		    Thread.sleep(500);
			
			WebElement alert1 = driver.findElement(By.id("_status"));
		    sa.assertTrue(alert1.isDisplayed());
			
			driver. manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	
					
		}  
		sa.assertAll();
		wb.close();
		
	} catch (IOException e) {
		System.out.println("File not found");
		e.printStackTrace();
	}

	}
}
