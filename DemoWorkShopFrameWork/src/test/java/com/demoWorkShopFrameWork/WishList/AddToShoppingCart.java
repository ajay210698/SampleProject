package com.demoWorkShopFrameWork.WishList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.WorkShopFrameWork.BaseClass.BaseClassUtility;
import com.aventstack.extentreports.Status;
import com.demoWorkshopFrameWork.Genric.threadLocalUtility.UtilityClassObject;
import com.google.common.collect.ObjectArrays;
import com.pom.LogedInPage;

public class AddToShoppingCart extends BaseClassUtility {
	@Test(dataProvider = "DataProvider")
	public void addComputerTo(String name) throws Throwable {
		
 		//lip = new LogedInPage(driver);
		
		lip.getSerchField().sendKeys(pu.getDataFromPropertyFile("serch"));
		lip.getSerchButton().click();
		
		 String price = UtilityClassObject.getDriver().findElement(By.xpath("//a[text()='"+name+"']/../../div[3]/div[1]/span")).getText();
			Reporter.log(name+"="+price,true);
			
			softAssert.assertEquals("ABCD","BCDA");
			UtilityClassObject.getTest().log(Status.FAIL,"xyz");
			softAssert.assertAll();
		//	driver.findElement(By.xpath("//a[text()='Log out']")).click();
	}
	
	
	@DataProvider
	public Object [][] DataProvider() throws Throwable
	{
		Object[][] obj= new Object [3][1];
		obj[0][0] =  pu.getDataFromPropertyFile("product1");
		obj[1][0] =  pu.getDataFromPropertyFile("product2");
		obj[2][0] =  pu.getDataFromPropertyFile("product3");
		return obj;
	}

}
