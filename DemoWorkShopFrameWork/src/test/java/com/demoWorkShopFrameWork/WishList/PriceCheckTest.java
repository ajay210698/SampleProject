package com.demoWorkShopFrameWork.WishList;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.WorkShopFrameWork.BaseClass.BaseClassUtility;
import com.aventstack.extentreports.Status;
import com.demoWorkshopFrameWork.Genric.threadLocalUtility.UtilityClassObject;

public class PriceCheckTest extends BaseClassUtility {
	@Test(dataProvider = "DataProvider")
	public void addComputerTo(String name) throws Throwable {
		
 		//lip = new LogedInPage(driver);
		
		lip.getSerchField().sendKeys(pu.getDataFromPropertyFile("serch"));
		lip.getSerchButton().click();
		
		 String price = UtilityClassObject.getDriver().findElement(By.xpath("//a[text()='"+name+"']/../../div[3]/div[1]/span")).getText();
			Reporter.log(name+"="+price,true);
		UtilityClassObject.getTest().log(Status.PASS,"ashgddm");
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
