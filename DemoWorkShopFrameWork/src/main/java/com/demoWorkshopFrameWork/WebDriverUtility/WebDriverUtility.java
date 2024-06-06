package com.demoWorkshopFrameWork.WebDriverUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demoWorkshopFrameWork.Genric.threadLocalUtility.UtilityClassObject;

public class WebDriverUtility {

	public  void ImplicitWait(WebDriver driver) {
		Timeouts impwait = driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	public  void explicitWait(WebDriver driver,WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10) );
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public  void selectValueFromDropdownByVisibleText(String text,WebElement element) {
		Select select =new Select(element);
		select.selectByVisibleText(text);
	}
	public  void selectValueFromDropdownByIndex(int text,WebElement element) {
		Select select =new Select(element);
		select.selectByIndex(text);
	}
	public  void selectValueFromDropdownByValue(String text,WebElement element) {
		Select select =new Select(element);
		select.selectByValue(text);
	}
	public  void moveToElement(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}
	public  void ContextClick(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element);
	}
	public  void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public  void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}public void switchtoFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchtoFrame(WebDriver driver, String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	public void switchtoFrame(WebDriver driver, WebElement elemet)
	{
		driver.switchTo().frame(elemet);
	}

}
