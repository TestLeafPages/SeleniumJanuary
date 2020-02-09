package week3.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		driver.findElementByXPath("//li[text()='Item 1']").click();
	
		driver.switchTo().defaultContent();
		driver.findElementByLinkText("Download").click();
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
