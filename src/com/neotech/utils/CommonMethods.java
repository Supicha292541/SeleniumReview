package com.neotech.utils;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes.Name;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Return;

public class CommonMethods extends BaseClass {

	public static void sendText(WebElement element, String text) {
		
		element.clear();
		element.sendKeys(text);	
		
	}
	
	public static void sendText(String xPath, String text) {
		WebElement element = driver.findElement(By.xpath(xPath));
		element.clear();
		element.sendKeys(text);	
		
	}
	
	
	public static void clickRadioOrCheckbox(List<WebElement> elementList, String selectValaue) {
		
		for (WebElement el: elementList) {
			String elementValue = el.getAttribute("value").trim();
			
			if (elementValue.equals(selectValaue) && el.isEnabled()) {
				el.click();
				break;
			}
		}
	}
	
	public static void wait(int seconds) throws InterruptedException {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		
		}
	}
	
	public static void selectDropdown(WebElement element, String visibleText) {
		try {
			Select sel = new Select(element);
			sel.selectByVisibleText(visibleText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	protected static void selectDropdown(WebElement element, int index) {
		try {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static void accepAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		
	}
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
		public static String getAlertText() {
		String alertText = null;
		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();	
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		
		return alertText;
	}
	
	public static void sendAlertText(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}
	
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}		
	}

	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		
		for (String handle: handles) {
			if (!mainWindow.equals(handles)) {
				driver.switchTo().window(handle);
				break;
			}
		}
	
	}
	
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLCIT_WAIT_TIME));
		return wait;
 	}
	
	public static WebDriverWait getWaitObject(int secondToWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secondToWait) );
		return wait;
 	}
	
	public static WebElement waitforClickability(WebElement element ) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static WebElement waitForVisibility(WebElement element ) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void click(WebElement element) {
		waitforClickability(element);
		element.click();
	}
}