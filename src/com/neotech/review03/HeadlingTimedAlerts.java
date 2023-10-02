package com.neotech.review03;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.utils.BaseClass;

public class HeadlingTimedAlerts  extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		//url=https://neotech.vercel.app/alerts
	setUp();
	
	WebElement alertBtn = driver.findElement(By.id("btnAlert"));
	alertBtn.click();
	
	//Handing the Alert
	Alert alert = driver.switchTo().alert();
	String alertText = alert.getText();
	System.out.println("The text of the alert is -> " + alertText);
	alert.accept();
	
	Thread.sleep(1000);
	
		
	//Handing the Delayed Alert
	//driver.findElement(By.id("btnDeleayedAlert")).click();
	
	//alert = driver.switchTo().alert();
	//Thread.sleep(10000);
	//alert = driver.switchTo().alert();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.alertIsPresent());
	
	// if alert is present in 3 second, I will wait only 3s
	
	alert = driver.switchTo().alert();
	Thread.sleep(1000); //alert wait 3s
	
	alert.accept();
	Thread.sleep(1000); // alert close
	
	tearDown();
	}

}
