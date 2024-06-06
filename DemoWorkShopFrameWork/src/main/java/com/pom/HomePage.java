package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//a[@class='ico-login']")
	private WebElement LoginLink;
	
	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCart;
	
	@FindBy(xpath = "//span[text()='Wishlist']")
	private WebElement Wishlist;

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public void setRegisterLink(WebElement registerLink) {
		this.registerLink = registerLink;
	}

	public WebElement getLoginLink() {
		return LoginLink;
	}

	public void setLoginLink(WebElement loginLink) {
		LoginLink = loginLink;
	}

	public WebElement getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(WebElement shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public WebElement getWishlist() {
		return Wishlist;
	}

	public void setWishlist(WebElement wishlist) {
		Wishlist = wishlist;
	}

}
