package com.neotech.review04;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;
import com.neotech.utils.CommonMethods;

public class UploadExample extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		// https://neotech.vercel.app/fileUpload
		
		setUp();
		
		String filePath = System.getProperty("user.dir") + "/screenshots/Form.png";
		
		driver.findElement(By.id("image_file")).sendKeys(filePath);
		
		driver.findElement(By.id("btnUpload")).click();
		
		// Let wait for the div with class "ContactUs" to be visible
		waitForVisibility(driver.findElement(By.cssSelector("div.ContactUs")));
		
		String expectedMessage = "File uploaded successfully!";
		String actualMessage = driver.findElement(By.id("upload_response")).getText();
		
		String destinationPath = "screenshots";
		
		if (actualMessage.contains(expectedMessage)) {
			// Test Passed
			destinationPath += "/passed/upload.png";
		} else {
			// Test Failed
			destinationPath += "/failed/upload.png";
		}

		TakesScreenshot ts = (TakesScreenshot) driver.findElement(By.cssSelector("div.css-0"));
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(destinationPath);

		
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		wait(1);
		
		tearDown();

	}

}
