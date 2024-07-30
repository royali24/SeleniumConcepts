package SeleniumPractice.SeleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinksInPageCount {

	WebDriver driver; 
	
	@BeforeTest
	public void setUp() {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@Test
	public void countLinks() {
		
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
		driver.quit();
	}
}
