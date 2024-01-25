package com.jbk.test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.jbk.pages.LoginPage;
import com.listener.ListenerDemo;

@Listeners(ListenerDemo.class)
public class LoginTest extends TestBase {
	public WebDriver driver;
	public LoginPage lp;
	public static Logger Log=Logger.getLogger(LoginTest.class);

	@BeforeMethod
	public void openBrowser() throws IOException {
		Log.info("Open browser...");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		/*driver = new ChromeDriver();
		driver.get("file:///C:/Users/PUSHKRAJ/Downloads/Selenium%20Softwares/Selenium%20Softwares/Offline%20Website/index.html");
		driver.manage().window().maximize();*/
		driver = initialization();
		lp = new LoginPage(driver);
	}

	
	@Test
	public void verifyTitleOfDash() {
		Log.info("Testcase Start...");
		//Log.warn(Log);
		lp.correctData();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	
	public WebDriver initialization() throws IOException {
		Log.info("Initializing a browser with name: "+ readProperty("browser"));
		
		if (readProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}else {
			
		}
		return driver;
	}


}
