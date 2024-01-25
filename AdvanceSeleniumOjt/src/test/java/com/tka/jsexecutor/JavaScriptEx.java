package com.tka.jsexecutor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JavaScriptEx {

	static WebDriver driver;
	RemoteWebDriver re;

	public void waitForElement(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitWithFluent(WebElement element, long time) {
		Wait w = new FluentWait(driver).withTimeout(time, TimeUnit.SECONDS).pollingEvery(3, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

		w.until(ExpectedConditions.visibilityOf(element));

	}

	public void moveAndClick(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click(element).build().perform();
	}

	public static void scrollingToView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	@Test
	public void test01() throws Exception {

		WebElement uname, pass;
		RemoteWebDriver rd;
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///C:/Users/PUSHKRAJ/Downloads/Selenium%20Softwares/Selenium%20Softwares/Offline%20Website/index.html");
		// driver.navigate().to("");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;// type casting

		js.executeScript("window.location='https://javabykiran.com/playground/'");

		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		WebElement tables = driver.findElement(By.linkText("Tables"));
		js.executeScript("arguments[0].scrollIntoView(true);", tables);

		Thread.sleep(5000);
		WebElement link = driver.findElement(By.linkText("Accessing Links"));
		js.executeScript("arguments[0].scrollIntoView(true);", link);

		Thread.sleep(5000);

		driver.navigate().to("file:///C:/Users/PUSHKRAJ/Downloads/Selenium%20Softwares/Selenium%20Softwares/Offline%20Website/index.html");
		System.out.println(driver.getCurrentUrl());
		System.out.println("URL printed by JS " + js.executeScript("return document.URL;"));

		System.out.println(driver.getTitle());// jbk- log in
		System.out.println("title printed by JS " + js.executeScript("return document.title;"));

		// changing title by js
		js.executeScript("document.title='updated title';");
		System.out.println(driver.getTitle());// updated title

		driver.navigate().refresh();
		// refreshing browser by js
		js.executeScript("history.go(0);");

		// clicking element by js
		js.executeScript("arguments[0].click();", uname = driver.findElement(By.id("email")));

		js.executeScript("document.getElementById('email').value='kiran@gmail.com';");

		System.out.println(driver.findElement(By.id("email")).getAttribute("value"));

		// clicking element by js

		js.executeScript("arguments[0].click();", pass = driver.findElement(By.id("password")));

		// using sendkeys by js

		js.executeScript("document.getElementById('password').value='123456';");

		// creating alert by js
		js.executeScript("alert('hello world');");// optional
		Alert al = driver.switchTo().alert();
		System.out.println(al.getText());
		Thread.sleep(5000);
		al.accept();

		// driver.navigate().to("");
		// navigating to other url by js

	}

	// @Test
	public void test02() {
		ArrayList<String> demo = new ArrayList<String>();
		demo.add("kiran");
		demo.add("mangesh");
		demo.add("neelam");
		demo.add("ashwini");
		demo.add("amol");

		HashSet<String> demo1 = new HashSet<String>();
		demo1.add("kiran");
		demo1.add("mangesh");
		demo1.add("neelam");
		demo1.add("ashwini");
		demo1.add("amol");

		Set<String> demo2 = new HashSet<String>();
		demo2.add("kiran");
		demo2.add("mangesh");
		demo2.add("neelam");
		demo2.add("ashwini");
		demo2.add("amol");

		System.out.println(demo);
		System.out.println(demo1);
		System.out.println(demo2);
	}

	/*
	 * 
	 * [kiran, mangesh, neelam, ashwini, amol] [kiran, amol, mangesh, neelam,
	 * ashwini] [kiran, amol, mangesh, neelam, ashwini]
	 */

}
