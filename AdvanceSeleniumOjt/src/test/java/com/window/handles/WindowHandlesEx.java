package com.window.handles;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandlesEx {

	@Test
	public void test01() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/PUSHKRAJ/Downloads/Selenium%20Softwares/Selenium%20Softwares/Offline%20Website/index.html");
	    driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
	    driver.findElement(By.id("password")).sendKeys("123456");
	    driver.findElement(By.xpath("//button")).click();
	    
	    List<WebElement> links = driver.findElements(By.xpath("//a[text()='More info ']"));
	    // only 1 window
	    String mainWindow = driver.getWindowHandle();
	    for (WebElement element : links) {
			element.click();
		}
	    // 5 windows
	    Set<String> allWindows = driver.getWindowHandles(); // 5 values
	    
	    for (String window : allWindows) {
	    	System.out.println("The handle of window is: "+window);
			if(!window.equals(mainWindow)) {
				driver.switchTo().window(window); // 4 times
				System.out.println(driver.getCurrentUrl());
				Thread.sleep(3000);
				driver.close();
			}
		}
	}

}
