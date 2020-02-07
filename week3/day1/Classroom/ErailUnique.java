package week3.day1.Classroom;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailUnique {

	public static void main(String[] args) throws InterruptedException {
		
//		Set the system property and Launch the URL
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		Click the 'sort on date' checkbox
		driver.findElement(By.id("chkSelectDateOnly")).click();
//		clear and type in the from station text field
		driver.findElement(By.id("txtStationFrom")).clear();
		driver.findElement(By.id("txtStationFrom")).sendKeys("MAS", Keys.TAB);
//		clear and type in the to station text field
		driver.findElement(By.id("txtStationTo")).clear();
		driver.findElement(By.id("txtStationTo")).sendKeys("SBC",Keys.TAB, Keys.ENTER);
//		Add a java sleep for 2 seconds
		Thread.sleep(2000);
//		Store all the train names in a list
		List<WebElement> allTrainNames = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//td[2]");
//		Get the size of it
		System.out.println(allTrainNames.size());
//		Add the list into a new Set
		Set<WebElement> unique = new HashSet<WebElement>(allTrainNames);
//		And print the size of it
		System.out.println(unique.size());

	}

}
