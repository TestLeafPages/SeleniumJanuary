package week3.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandles {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("home").click();
		/*
		 * String currentWindow = driver.getWindowHandle();
		 * System.out.println(currentWindow);
		 */
		Set<String> allWindows = driver.getWindowHandles();
		List<String> ls = new ArrayList<String>(allWindows);
		driver.switchTo().window(ls.get(1));
		
		//Take screenshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./snaps/img.png");
		//Copying file from source to destination
		FileUtils.copyFile(src, dst);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
