package com.stepdef;

import org.openqa.selenium.WebDriver;

import com.generic.BaseLogin;
import com.generic.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	WebDriver driver;
	@Given("Open browser & go to zoopla URL")
	public void getsetup() {
		driver = new DriverManager().getDriver();
	}
	@When("try to login with credential")
	public void getLogin() {
		new BaseLogin().getLogin(driver);
	}
	@Then("validate login was success")
	public void getvalidation() {
		driver.quit();
	}

}
