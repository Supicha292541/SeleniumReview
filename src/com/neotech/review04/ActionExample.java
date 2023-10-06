package com.neotech.review04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.neotech.utils.CommonMethods;

public class ActionExample extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		// http://webdriveruniversity.com/Actions/index.html
		
		setUp();
		
		Actions act = new Actions(driver);
		
////////////////////////////////////////////////////////////////////////		
//		// Drag And Drop
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
	
		act.dragAndDrop(draggable, droppable).perform();
		//Don't forget the perform() at the ead
		
		act.clickAndHold(draggable).moveToElement(droppable).pause(1000).release().perform();
////////////////////////////////////////////////////////////////////////		
//		
//		// Double click
		WebElement dbClickBt = driver.findElement(By.id("double-click"));
		
		// Does clicking 2 times work? -> No
		//dbClickBt.click();
		//dbClickBt.click();
	act.doubleClick(dbClickBt).perform();
//////////////////////////////////////////////////////////////////////////		
		
		//Mouse Hover
		
		List<WebElement> hoverButtons =	driver.findElements(By.cssSelector("buttton.dropbtn"));
	
	for(WebElement hover : hoverButtons) {
			act.moveToElement(hover).perform();
			wait(1);
		}
		
	
//////////////////////////////////////////////////////////////////////////	
		
		WebElement div = driver.findElement(By.id("click-box"));
		act.clickAndHold(div).pause(2000).release().pause(1000).clickAndHold(div).pause(1000).perform();
		
		tearDown();
	}

}
