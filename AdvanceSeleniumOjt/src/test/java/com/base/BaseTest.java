package com.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;

	@BeforeTest
	public void setUp() throws IOException {
		
		if(driver==null) {
		System.out.println("The path is: "+System.getProperty("user.dir"));
		FileReader fr = new FileReader("\\src\\test\\resourses\\configfiles\\config.properties");
		prop.load(fr);
		}
	
	if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
	//	WebDriverManager.chromedriver().setUp();
		WebDriver driver = new ChromeDriver();
	}
	}
}
