package com.neotech.review03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.neotech.utils.BaseClass;

public class WebTableExample  extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		//url=https://neotech.vercel.app/tables
		
		setUp();
		
		// Fine the number of rows
		List<WebElement> rows= driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("The number of rows is -> " + rows.size());
		
		List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		System.out.println("The number of columns is -> " + cols.size());
		
		List<WebElement> cells = driver.findElements(By.xpath("//table/tbody/tr/td"));
		System.out.println("The number of cells is -> " + cells.size());
	
		System.out.println("---------------------------------");
		
		//If i want to print the first row of the table
		
		//1st way
		
		List<WebElement> fRows = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));	
		for (WebElement el : fRows) {
			System.out.print(el.getText() + " | ");
		} 
		
		System.out.println();
		
		System.out.println("------------------------------------");
		
		//2nd way
		
		for (int i = 1; i < cols.size(); i++) {
			String path = "//table/tbody/tr[1]/td[" + i + "]";
			//System.out.println(path);
			
			WebElement cell	 = driver.findElement(By.xpath(path));
			System.out.print(cell.getText() + " | ");
		}
		
		System.out.println();
		
		System.out.println("---------------------------------------");
		System.out.println("Let us print all the cells of all the rows");
		System.out.println("---------------------------------------");
		
		for (int row = 1; row <= rows.size(); row++) { //iterating the row
			
			for (int col = 1; col <= cols.size(); col++) { //iterating the columns
				//String path = "//table/tbody/tr[" + row + "]/td[" + col + "]";
				//System.out.println(path);
				
				WebElement element = driver.findElement(By.xpath("//table/tbody/tr[" + row + "]/td[" + col + "]"));
				System.out.println(element.getText());
			}
			
			System.out.println();
		}
		
		Thread.sleep(1000);
		tearDown();
		
		
		
		
		
		
	}

}
