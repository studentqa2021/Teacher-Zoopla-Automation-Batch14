package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.util.BaseConfig;
import com.util.Highlighter;
import com.util.ScreenShot;

public class BaseLogin {

	public void getLogin(WebDriver driver) {
		// code for login >> xpath PF/POM
		MasterPageFactory pf = new MasterPageFactory(driver);

		// screenshot>> TakeScreenShot
		ScreenShot.getScreenShot(driver, "Home page");

		if (pf.getAcceptAllCookiesBtn().size() > 0) {// list total no = size()

			Highlighter.addColor(driver, pf.getAcceptAllCookiesBtn().get(0));
			pf.getAcceptAllCookiesBtn().get(0).click();// click
		}

		pf.getFirstSigninBtn().click();
		pf.getEmail().sendKeys(new BaseConfig().getData("user"));
		pf.getPass().sendKeys(new BaseConfig().getData("pass"));
		if (pf.getAcceptAllCookiesBtn().size() > 0 
				&& pf.getAcceptAllCookiesBtn().get(0).isDisplayed() ){// list total no = size()
			Highlighter.addColor(driver, pf.getAcceptAllCookiesBtn().get(0));
			pf.getAcceptAllCookiesBtn().get(0).click();// click
		}
		
		Actions ac = new Actions(driver);
		Highlighter.addColor(driver, pf.getSeconfSigninBtn());
		ac.moveToElement(pf.getSeconfSigninBtn()).perform();
		System.out.println("I am here>>>> click now");
		pf.getSeconfSigninBtn().click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mouse hover >> Actions class>>must need to use perform()
		
		ac.moveToElement(pf.getMyZooplaBtn()).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// sign out will be visible
		if (pf.getSignOutBtn().isDisplayed()) {
			System.out.println("Test Login function passed");
			Assert.assertTrue(pf.getSignOutBtn().isDisplayed(),"sign out btn found");
		} else {
			System.out.println("Test login function  failed");
			Assert.assertTrue(pf.getSignOutBtn().isDisplayed(),"Signout btn not found");
		}

	}

	public static void main(String[] args) {
		DriverManager dm = new DriverManager();
		WebDriver driver = dm.getDriver();// browser+ URL
		BaseLogin bl = new BaseLogin();
		bl.getLogin(driver); // actual login code

	}

}
