package com.neotech.review02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;
import com.neotech.utils.ConfigsReader;

public class LoginSIS extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
	
		setUp();
		
		//We are doing out test
		Thread.sleep(1000);
		
		WebElement username = driver.findElement(By.id("tUsername"));
		username.sendKeys(ConfigsReader.getProperty("username"));//Admin
		Thread.sleep(1000);
		
		driver.findElement(By.name("tPassword")).sendKeys(ConfigsReader.getProperty("password"));
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		tearDown();
	}

}
