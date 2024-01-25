package com.listener;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {

	// When Test case get failed, this method is called.
	public void onTestFailure(ITestResult Result) {
		TakesScreenshot ts = (TakesScreenshot)LoginTest.driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+"/ScreenS");
		System.out.println("The name of the testcase failed is :" + Result.getName());
	}

	// When Test case get Skipped, this method is called.
	public void onTestSkipped(ITestResult Result) {
		System.out.println("The name of the testcase Skipped is :" + Result.getName());
	}

	// When Test case get Started, this method is called.
	public void onTestStart(ITestResult Result) {
		System.out.println(Result.getName() + " test case started");
	}

	// When Test case get passed, this method is called.
	public void onTestSuccess(ITestResult Result) {
		System.out.println("The name of the testcase passed is :" + Result.getName());
	}
}
