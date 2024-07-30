package com.OrangeHRM.PageObjects;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrangeHRM {

	public String baseURL ="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public WebDriver driver;

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	@Test
	public void clickLogin() {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		
		String pageTitle = driver.getTitle();
		System.out.println("pageTitle: " +pageTitle);
		
		Assert.assertEquals("OrangeHRM", pageTitle);
		
	}
	@Test
	public void logout() {
		driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
		driver.findElement(By.xpath("//ul[@class='oxd-dropdown-menu']/li[4]/a")).click();
		 
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {

		Thread.sleep(5000);

		driver.close();
		driver.quit();
	}
}
