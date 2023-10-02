package com.neotech.review03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class HandlingFrames extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		//url=https://the-internet.herokuapp.com/iframe
			
		setUp();
		
		// 1st way. switching by index
		// 2nd by ID
		// 3rd by Webelement
		
		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id= 'mce_0_ifr']"));
		driver.switchTo().frame(frameElement);
		
		WebElement bodyElemnt = driver.findElement(By.xpath("//body[@id='tinymce']"));
		
		bodyElemnt.clear();
		bodyElemnt.sendKeys("AC Milan is better than Inter Milan");
		Thread.sleep(2000);
		
		//driver.findElement(By.linkText("Elemental Selenium")).click();
		
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Elemental Selenium")).click();
		
		Thread.sleep(2000);
		tearDown();
		
		
	}

}
