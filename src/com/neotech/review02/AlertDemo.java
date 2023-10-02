package com.neotech.review02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

public class AlertDemo extends BaseClass{
	// https://nxtgenaiacademy.com/alertandpopup/
	public static void main(String[] args) throws InterruptedException {
		
		setUp();
		
		Thread.sleep(1000);
		
		driver.findElement(By.name("confirmalertbox")).click();
		
		//driver.findElement(By.name("promptalerbox1234"));
		
		Alert confiAlert =	driver.switchTo().alert();
		Thread.sleep(1000);
		
		System.out.println("The text of the Alert -> " + confiAlert.getText() );
		
		//confiAlert.dismiss(); // Clicking on cancel
		confiAlert.accept(); // Clicking on  ok
		Thread.sleep(1000);
		
		driver.findElement(By.name("promptalertbox1234")).click();
		
		Alert promptAlert = driver.switchTo().alert();
		Thread.sleep(2000);

		promptAlert.sendKeys("Yes");
		promptAlert.accept();
		
		Thread.sleep(2000);
		tearDown();
	}

}
