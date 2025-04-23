package com.CoverFox_Listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.CoverFox_Base.Base1;
import com.CoverFox_Utility.Utility1;

public class Listener extends Base1 implements ITestListener{
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{	
		 
	    Reporter.log("Test "+result.getName()+" is success", true);
	}
	@Override
	public void onTestFailure(ITestResult result) 
	{
		
		Reporter.log("Test "+result.getName()+" is Failed", true);	
		try {
			Utility1.takeScreenshot(driver, "FailedTCScreenshot");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
