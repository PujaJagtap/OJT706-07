package com.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{

	int count=1;
	int maxLimit=3;
	public boolean retry(ITestResult result) {
		if(count<=maxLimit) {  //1,2,3
			count++;  //2,3,4
			return true;
		}
		return false;
	}
	

}
