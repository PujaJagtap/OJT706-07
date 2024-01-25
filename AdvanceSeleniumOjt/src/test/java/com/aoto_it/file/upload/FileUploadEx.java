package com.aoto_it.file.upload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadEx {

	@Test
	public void test01() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriverAutoIT.exe");  // AutoIT_chromeDriver
	    WebDriver driver = new ChromeDriver();
		driver.get("https://javabykiran.com/playground/file-upload");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("file")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button")).click();
		Runtime.getRuntime().exec("D:/Au3/FileUpload.exe");   // or //"D:\\Au3\\FileUpload.exe"
}
}