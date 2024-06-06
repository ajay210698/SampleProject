package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id = "Email")
	private WebElement EmailText;
	
	@FindBy(id = "Password")
	private WebElement passWordText;
	
	@FindBy(xpath = "//input[@class='button-1 login-button']")
	private WebElement LoginBtn;
	
	@FindBy(xpath = "//a[text()='Forgot password?']")
	private WebElement forgotPasswordLink;
	
	@FindBy (className = "validation-summary-errors")
	private WebElement errorMsg;
	
	public WebElement getEmailText() {
		return EmailText;
	}

	public WebElement getPassWordText() {
		return passWordText;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getErrorMsg() {
		return errorMsg;
	}
	
	 
}
