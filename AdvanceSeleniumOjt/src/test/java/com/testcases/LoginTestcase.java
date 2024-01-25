package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.utilities.ReadXLSdata;

public class LoginTestcase {
	
	 public static WebDriver driver;
	 @Test(dataProviderClass = ReadXLSdata.class,dataProvider = "data")
	 public void loginTest(String email, String password) {
//	    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//			driver = new ChromeDriver();
//			driver.get(testurl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		//	driver.findElement(By.xpath(Loc.)).sendKeys(email);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
}
}