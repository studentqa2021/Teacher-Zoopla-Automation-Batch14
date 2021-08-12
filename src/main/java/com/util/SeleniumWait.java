package com.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait {

	public void getImplicitWait(WebDriver driver, WebElement element) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void getExplicitWait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void getFluentWait(WebDriver driver, WebElement element) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(5, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void getCustomWait(WebDriver driver, WebElement element) {

		
		
	}

}
