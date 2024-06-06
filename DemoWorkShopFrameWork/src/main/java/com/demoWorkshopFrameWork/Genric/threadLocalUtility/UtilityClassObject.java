package com.demoWorkshopFrameWork.Genric.threadLocalUtility;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {

	public static ThreadLocal<WebDriver>driver= new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest>Test= new ThreadLocal<ExtentTest>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver Sdriver) {
		driver.set(Sdriver);
	}
	public static  ExtentTest getTest()
	{
		return Test.get();
	}
	public static void setTest(ExtentTest Stest)
	{
		Test.set((Stest));
	}
}
