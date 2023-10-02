package com.neotech.review01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		String url = "https://www.amazon.com/";
		driver.get(url);
		
		Thread.sleep(1000);
		
		Thread.sleep(5000);

		// There are 8 locators to find the elements in DOM
		// id, name, className, linkText, partialLinkText, tagName, xPath, cssSelector

		WebElement searchText = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchText.sendKeys("Messi jersey");
		Thread.sleep(1000);

		WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchButton.click();
		
		Thread.sleep(3000);
		driver.quit();

	}
}
