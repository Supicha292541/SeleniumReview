package com.neotech.review01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class LaunchFirefoxBrowser {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		
		//WebDriver driver = new ChromeDriver();

		System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		
		String url = "https://www.nytimes.com/games/wordle/";
		
		driver.get(url);
		Thread.sleep(1000); 
		
		String currentURL = driver.getCurrentUrl();
		if (url.equals(currentURL)) {
			System.out.println("Urls are the same");
		} else {
			System.out.println("Urls are different");
		}
		
		System.out.println(url);
		System.out.println(currentURL);
		
		String title = driver.getTitle();
		System.out.println("title -> " + title);
		
		
		driver.quit();
		
	}

}
