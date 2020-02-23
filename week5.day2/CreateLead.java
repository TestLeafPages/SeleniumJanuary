package testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import week5.day2.ReadExcel;

public class CreateLead {
	ChromeDriver driver;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void login(String url, String username, String password) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("username").sendKeys(username);
		driver.findElementById("password").sendKeys(password);
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
	}
	
	@Test(dataProvider = "getData")
	public void createNewLead(String cn, String fn, String ln) {	
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys(cn);
		driver.findElementById("createLeadForm_firstName").sendKeys(fn);
		driver.findElementById("createLeadForm_lastName").sendKeys(ln);
		driver.findElementByName("submitButton").click();
	}
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	@DataProvider(name="getData")
	public String[][] fetchData() throws IOException {
		String[][] data = ReadExcel.getData("CreateLead");
		return data;
		
		
		
		
		/*
		 * String[][] data = new String[2][3]; data[0][0] = "TestLeaf"; data[0][1] =
		 * "Sam"; data[0][2] = "Lazarus";
		 * 
		 * data[1][0] = "IBM"; data[1][1] = "Aruna"; data[1][2] = "J";
		 * 
		 * return data;
		 */
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






