package com.testing;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.BaseLogin;
import com.generic.DriverManager;

public class TestExecution {
	WebDriver driver;

	@BeforeTest
	public void setup() {
		//report
		driver = new DriverManager().getDriver();
	}
	@Test
	public void login()  {
		new BaseLogin().getLogin(driver);
	
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
