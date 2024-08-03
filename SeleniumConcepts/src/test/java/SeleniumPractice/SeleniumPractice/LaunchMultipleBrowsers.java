package SeleniumPractice.SeleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LaunchMultipleBrowsers {
	WebDriver driver;
	WebDriver driver1;

	@Test
	public void startUp() {
		driver= new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		System.out.println("chrome opened");

		driver1= new EdgeDriver();
		driver1.get("http://www.google.com");
		System.out.println("edge opened");
		driver1.close();

		driver.switchTo().defaultContent();
		List<WebElement> link = driver.findElements(By.tagName("a"));
		int linkcount = link.size();

		System.out.println("Total number of links in google homepage: " + linkcount);

		for(int i=0; i<linkcount ; i++) {

			String linkText = link.get(i).getText();
			System.out.println("Link Text: " + linkText);

		}
	}
		@AfterTest
		public void tearDown() {
			driver.close();
		}

	}
