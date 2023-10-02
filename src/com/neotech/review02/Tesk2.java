package com.neotech.review02;

import java.sql.Driver;

import org.openqa.selenium.By;

import com.neotech.utils.BaseClass;

import net.bytebuddy.asm.Advice.OffsetMapping.Target.AbstractReadOnlyAdapter;

public class Tesk2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		// Preparing for the test
		setUp();
		
		//Do
		Thread.sleep(2000);
		//driver.fineElement(By.id(""));
		
		tearDown();
	}

}
