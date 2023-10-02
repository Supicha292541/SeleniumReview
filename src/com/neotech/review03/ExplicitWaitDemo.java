package com.neotech.review03;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class ExplicitWaitDemo extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		//url=https://demo.seleniumeasy.com/jquery-download-progress-bar-demo.html
		
		setUp();
	
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		
//		Thread.sleep(1000);
//		
//		driver.findElement(By.id("downloadButton")).click();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//div[text()='complete!']"));
	//***************************************//
//	
//		driver.findElement(By.id("downloadButton")).click();
//	
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Complete!']")));
//		
//			// Wait until the WebElement is visible
//			 //Wait for a maximum of 25 seconds
//		
//		WebElement label = driver.findElement(By.xpath("//div[text()='Complete!']"));
//		System.out.println("The label text -> " + label.getText());
//////////////////////////////////////////////////////////////////////////////
		
		driver.findElement(By.id("downloadButton")).click();
		
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
		fluentWait.withTimeout(Duration.ofMinutes(1)); // Maximum wait is van minut
		fluentWait.pollingEvery(Duration.ofSeconds(3)); // Try every 3 seconds
		fluentWait.ignoring(NoSuchElementException.class); // While truing ignore this exception

		// I will wait for the button Close to be in the page and Clickable
		fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Close']")));

		// Now we know that the Close button is clickable
		driver.findElement(By.xpath("//button[text()='Close']")).click();

		Thread.sleep(1000);

		
		tearDown();
	}

}
