package com.tka.grid;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGrid {

	RemoteWebDriver driver= null;
	String url="http://localhost:4444/wd/hub";
	@Parameters("port")
	@BeforeTest
	public void setup(String port)throws Exception {
		System.out.println(port);
		if(port.equals("4405")) {
			FirefoxOptions options= new FirefoxOptions();
			options.setCapability("browser", "firefox");
			options.setCapability("platform", "windows");
			driver = new RemoteWebDriver(new URL(url), options);
		}
		if(port.equals("4407")) {
			ChromeOptions options= new ChromeOptions();
			options.setCapability("browser", "chrome");
			options.setCapability("platform", "windows");
			driver = new RemoteWebDriver(new URL(url), options);
		}
	}
	@Test
	public void test01() throws Exception{
		
		driver.get("file:///C:/Users/PUSHKRAJ/Downloads/Selenium%20Softwares/Selenium%20Softwares/Offline%20Website/index.html");
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
		AssertJUnit.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
}
