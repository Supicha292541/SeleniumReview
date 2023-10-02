package com.neotech.review03;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

public class Disco extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		//url=https://neotech.vercel.app/windows
		
		setUp();
	
		driver.findElement(By.id("neo")).click();
		Thread.sleep(1000);
		
		Set<String> allHandles = driver.getWindowHandles();
		
		Iterator<String> it	 = allHandles.iterator();
		String handle1 = 	it.next();
		String handle2 = 	it.next();
		
		for (int i = 1; i < 10; i++) {
			driver.switchTo().window(handle1);
			Thread.sleep(500);
			driver.switchTo().window(handle2);
			Thread.sleep(500);
		}
		
		driver.close(); // will close ONLy the current tab/window
	//	driver.quit(); // will close All the open tabs/ windows
		
		tearDown();

	}

}
