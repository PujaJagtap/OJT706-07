package com.jbk.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static WebDriver driver;
	FileInputStream fis = null;
	public static Logger Log = Logger.getLogger(TestBase.class);
	
	public String readProperty(String key) throws IOException {
		
		Log.info("Reading values of key from property file: ");
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		Log.info("Value found in the property file for given key: "+ key);
		return prop.getProperty(key);
	    }
	
	public void launchAppplication() throws IOException {
		Log.info("Launching the application: ");
		driver.get(readProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);	
	}
	
	public WebDriver initialization() throws IOException {
		Log.info("Initialising a browser with name: "+readProperty("browser"));
		
		if(readProperty("browser").equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			Log.info("Chrome browser initialize");
			launchAppplication();
		
		}else {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
			Log.info("Firefox browser initialize");
			launchAppplication();
		}
			return driver;
		
	}

}
