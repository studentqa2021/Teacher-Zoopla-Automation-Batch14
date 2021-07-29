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

		if (pf.getAcceptAllCookiesBtn().isDisplayed()) {// if display then
			// highlight>> javaScriptExecutor
			Highlighter.addColor(driver, pf.getAcceptAllCookiesBtn());
			pf.getAcceptAllCookiesBtn().click();// click
		}

		pf.getFirstSigninBtn().click();
		pf.getEmail().sendKeys(new BaseConfig().getData("user"));
		pf.getPass().sendKeys(new BaseConfig().getData("pass"));
		pf.getSeconfSigninBtn().click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// mouse hover >> Actions class>>must need to use perform()
		Actions ac = new Actions(driver);
		ac.moveToElement(pf.getMyZooplaBtn()).perform();

		// sign out will be visible
		if (pf.getSignOutBtn().isDisplayed()) {
			System.out.println("Test Login function passed");
			Assert.assertTrue(pf.getSignOutBtn().isDisplayed());
		} else {
			System.out.println("Test login function  failed");
			Assert.assertTrue(pf.getSignOutBtn().isDisplayed());
		}

	}

	public static void main(String[] args) {
		DriverManager dm = new DriverManager();
		WebDriver driver = dm.getDriver();// browser+ URL
		BaseLogin bl = new BaseLogin();
		bl.getLogin(driver); // actual login code

	}

}