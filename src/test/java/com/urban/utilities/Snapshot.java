package com.urban.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Snapshot implements ITestListener
{
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestStart(result);
	}
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		try
		{
			String tname=result.getName();
			com.urban.reusablecomponents.reusabledriver.captureScreen(tname);
		}
		catch(Exception e)
		{
			System.out.println("Error in your screenshot code");
		}
	}
	@Override
	public void onTestFailure(ITestResult result) {
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestSkipped(result);
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailedWithTimeout(result);
	}
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//ITestListener.super.onFinish(context);
	}
}