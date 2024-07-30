package SeleniumPractice.SeleniumPractice;

import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class LaunchURL {
	
	String URL ;
	
	
	
	public WebDriver driver;
	String logo_xpath = "//a[@href='/ref=nav_logo']";
	
	
	@BeforeTest
	public void setup() {
		readURLFromConfigFile read = new readURLFromConfigFile();
		URL = read.getURL();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test
	public void launch() {
	driver.get(URL);
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(logo_xpath))));
	
	System.out.println("URL Launched");
	}
	
	@AfterTest
	public void close() {
		driver.close();
		driver.quit();
	}
}
