package com.neotech.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	private static Properties prop;
	
	public static void readProperties(String filePath) {
		
		try {
			FileInputStream fileIS = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fileIS);
		
		} catch(FileNotFoundException e){
			System.out.println("The file path is wrong!");
		} catch (IOException e2) {
			System.out.println("I couldn't read read the file");
		}
	}
	
	public static String getProperty(String key) {
	
		return prop.getProperty(key);
	
	}
}
