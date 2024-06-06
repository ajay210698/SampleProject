package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogedInPage {
	
	public LogedInPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);	
	}
	@FindBy (partialLinkText = "Book")
	private WebElement bookLink;
	
	@FindBy (partialLinkText = "Computers")
	private WebElement computer;
	
	@FindBy (partialLinkText = "Electronics")
	private WebElement electronics;
	
	@FindBy (partialLinkText = "Apparel & Shoes")
	private WebElement apparelShoes;
	
	@FindBy (partialLinkText = "Digital downloads")
	private WebElement digitalDownload;
	
	@FindBy (id = "small-searchterms")
	private WebElement serchField;
	
	@FindBy (xpath = "//input [@class='button-1 search-box-button']")
	private WebElement serchButton;
	
	//@FindBy (className = "button-1 search-box-button")
     //private WebElement serchButton;
	
	public WebElement getLogOutLink() {
		return logOutLink;
	}
	@FindBy(xpath = "//a[text()='Log out']")
	private WebElement logOutLink;

	public WebElement getSerchField() {
		return serchField;
	}

	
	public WebElement getSerchButton() {
		return serchButton;
	}

	public WebElement getBookLink() {
		return bookLink;
	}

	public WebElement getComputer() {
		return computer;
	}

	public WebElement getElectronics() {
		return electronics;
	}

	public WebElement getApparelShoes() {
		return apparelShoes;
	}

	public WebElement getDigitalDownload() {
		return digitalDownload;
	}
	
}
