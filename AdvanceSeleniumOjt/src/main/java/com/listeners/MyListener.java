package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener{
	public void onFinish(ITestContext contextFinish) {
	System.out.println("onFinish method finished");

	}
	public void onStart(ITestContext contextStart) {
	System.out.println("onStart method started");
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	System.out.println("Method failed with certain success percentage"+ result.getName());

	}

	public void onTestFailure(ITestResult result) {
	System.out.println("Method failed"+ result.getName());

}
	

}
