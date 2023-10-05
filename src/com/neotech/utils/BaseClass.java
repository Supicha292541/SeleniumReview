package com.neotech.utils;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	
	
	
	public static void setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
	
		switch(ConfigsReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			// open chrome browser
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			// open firefox browser
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			// Throw an exception
			throw new RuntimeException("Other browser are NOT supported!!!");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
	}
	
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
