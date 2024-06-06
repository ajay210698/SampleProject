package com.WorkShopFrameWork.BaseClass;

import java.time.LocalDateTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demoWorkshopFrameWork.Genric.FileUtility.ExcelUtility;
import com.demoWorkshopFrameWork.Genric.FileUtility.JsonUtility;
import com.demoWorkshopFrameWork.Genric.FileUtility.PropertiesFileUtility;
import com.demoWorkshopFrameWork.Genric.threadLocalUtility.UtilityClassObject;
import com.demoWorkshopFrameWork.WebDriverUtility.JavaUtility;
import com.demoWorkshopFrameWork.WebDriverUtility.WebDriverUtility;
import com.pom.HomePage;
import com.pom.LogedInPage;
import com.pom.LoginPage;

import lombok.experimental.UtilityClass;

@Listeners(com.demoWorkshopFrameWork.ListnerUtility.ListnersUtility.class)
public class BaseClassUtility {

	public ExcelUtility eu = new ExcelUtility();
	public JsonUtility ju = new JsonUtility();
	public PropertiesFileUtility pu = new PropertiesFileUtility();
	public WebDriver Sdriver = null;
  //  public ThreadLocal<WebDriver> driver = null;
	public HomePage hp;
	public LoginPage lp;
	public LogedInPage lip;
	public JavaUtility javaU;
	public WebDriverUtility wu;
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentReports Sreport;
	public ExtentTest test;
	public SoftAssert softAssert = new SoftAssert();

	@BeforeSuite
	public void name() {
	System.out.println("Execution started");

	}

	@BeforeClass
	public void Beforclass() throws Throwable {
		
		String Timestamp = LocalDateTime.now().toString().replace(":", "_");
		spark = new ExtentSparkReporter("./AdvanceReport/" + Timestamp + "report.html");
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os ", "windows");

		Sreport = report;

		String browser = pu.getDataFromPropertyFile("Browser");

		if (browser.equals("crome")) {
			Sdriver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			Sdriver = new EdgeDriver();
		} else {
			Sdriver = new ChromeDriver();
		}
//		sdriver = driver;
		UtilityClassObject.setDriver(Sdriver);
//	driver=UtilityClassObject.getDriver();

//		javaU = new JavaUtility();
//		wu = new WebDriverUtility();
//		wu.ImplicitWait(driver);

	}

	@BeforeMethod
	public void BeforMethod() throws Throwable {
		

		UtilityClassObject.getDriver().get(pu.getDataFromPropertyFile("Url"));
		lip = new LogedInPage(UtilityClassObject.getDriver());
		hp = new HomePage(UtilityClassObject.getDriver());
		hp.getLoginLink().click();
		lp = new LoginPage(UtilityClassObject.getDriver());
		lp.getEmailText().sendKeys(pu.getDataFromPropertyFile("Username"));
		lp.getPassWordText().sendKeys(pu.getDataFromPropertyFile("Password"));
		lp.getLoginBtn().click();

	}

	@AfterMethod
	public void afterMethod() throws Throwable {
		lip.getLogOutLink().click();
	}

	@org.testng.annotations.AfterClass
	public void AfterClass() {
//		softAssert.assertAll();
		UtilityClassObject.getDriver().quit();
	}

	@AfterSuite
	public void flushReport() {
		Sreport.flush();
	}

}
