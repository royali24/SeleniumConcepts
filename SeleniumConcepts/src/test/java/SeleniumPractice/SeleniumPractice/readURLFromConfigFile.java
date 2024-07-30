package SeleniumPractice.SeleniumPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class readURLFromConfigFile {

	String filepath = "C:\\Users\\royal\\eclipse-workspace\\SeleniumPractice\\config.properties";
	FileInputStream fis ;
	static String URL_Received;
	WebDriver driver;
	static Properties property ;
	@Test
	//read URL from config file and launch URL in chrome browser
	public void openFilePath() throws IOException {
		
			//File file = new File(filepath);
			//fis = new FileInputStream(file);
			//property = new Properties();
			//property.load(fis);
			//URL_Received = property.getProperty("URL");
			URL_Received= getURL();
			System.out.println("The URL from config property is: " + URL_Received);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			driver.get(URL_Received);
			System.out.println("URL Launched");

	}

	
	@AfterTest
	public void closeDriver(){
		driver.close();
		driver.quit();
	}
	
	//read URL from config file and send URL to LaunchURL.java class
	public String getURL(){
		try {
		File file = new File(filepath);
		fis = new FileInputStream(file);
		property = new Properties();
		property.load(fis);
		URL_Received = property.getProperty("URL");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return URL_Received;
	}
}
