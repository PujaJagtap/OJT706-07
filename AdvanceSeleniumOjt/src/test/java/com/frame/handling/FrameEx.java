package com.frame.handling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameEx {
	@Test
	public void test01() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Account
		driver.findElement(By.id("account_dd")).click();
		
		//Login/Sign Up
		driver.findElement(By.id("user_sign_in_sign_up")).click();
		
		//frame:iframe tag
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='modalIframe']"));
		driver.switchTo().frame(frame);
		//*[@id="mobileNoInp"]
		driver.findElement(By.id("mobileNoInp")).sendKeys("9812345660");
		//*[@id="container"]/div/div[2]/span[1]
	}
}
