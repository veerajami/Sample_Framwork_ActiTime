package com.actitime.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int retrylimit=3;
	int counter=0;

	public boolean retry(ITestResult result) {
		
		if(counter<retrylimit)
			{
			counter++;
			return true;
			}
		
		return false;
	}

}
