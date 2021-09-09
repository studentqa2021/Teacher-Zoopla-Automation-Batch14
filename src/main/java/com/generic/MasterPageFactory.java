package com.generic;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MasterPageFactory {
	
	public MasterPageFactory(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath ="(//*[contains(text(),'Accept all cookies')])[2]")
	private List<WebElement>  acceptAllCookiesBtn;

	@FindBy(xpath ="(//*[@class='css-k008qs eptm4aq7']//a)[3]")
	private WebElement  firstSigninBtn;
	
	@FindBy(xpath ="//*[@name='email']")
	private WebElement  email;
	
	@FindBy(xpath ="//*[@name='password']")
	private WebElement  pass;
	
	@FindBy(xpath ="//*[@data-testid='signin-button']")
	private WebElement  seconfSigninBtn;
	
	@FindBy(xpath ="(//*[contains(text(),'My Zoopla')])[1]")
	private WebElement  myZooplaBtn;
	
	@FindBy(xpath ="(//*[@class='esdwd6d0 css-wxwl91-StyledLink-Link e33dvwd0'])[5]")
	private WebElement  signOutBtn;

	public List<WebElement> getAcceptAllCookiesBtn() {
		return acceptAllCookiesBtn;
	}

	public WebElement getFirstSigninBtn() {
		return firstSigninBtn;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPass() {
		return pass;
	}

	public WebElement getSeconfSigninBtn() {
		return seconfSigninBtn;
	}

	public WebElement getMyZooplaBtn() {
		return myZooplaBtn;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}
	
	
	

}
