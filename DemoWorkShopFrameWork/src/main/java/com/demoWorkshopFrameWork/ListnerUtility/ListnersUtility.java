package com.demoWorkshopFrameWork.ListnerUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.IRetryAnalyzer;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.WorkShopFrameWork.BaseClass.BaseClassUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demoWorkshopFrameWork.Genric.threadLocalUtility.UtilityClassObject;

public class ListnersUtility implements ITestListener, ISuiteListener, IRetryAnalyzer {
	public ExtentSparkReporter spark;

	public ExtentTest test;

	@Override
	public boolean retry(ITestResult result) {

		return false;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName());

		String methodName = result.getMethod().getMethodName();
		TakesScreenshot tss = (TakesScreenshot) UtilityClassObject.getDriver();
		String RSS = tss.getScreenshotAs(OutputType.BASE64);

		File tempLoc = tss.getScreenshotAs(OutputType.FILE);
		String Timestamp = LocalDateTime.now().toString().replace(":", "-");
		File permLoc = new File("./DrfectShots/" + methodName + Timestamp + ".png");
		try {
			FileHandler.copy(tempLoc, permLoc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		test.addScreenCaptureFromBase64String(RSS, "DefectShots");
//	    spark= new ExtentSparkReporter("./AdvanceReport"+Timestamp+"report.html");
//	    report = new ExtentReports();
//	    report.attachReporter(spark);
//	    report.setSystemInfo("os ","windows");

	}

	@Override
	public void onTestStart(ITestResult result) {
		test = BaseClassUtility.Sreport.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
