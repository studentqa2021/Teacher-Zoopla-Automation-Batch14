package com.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Click {
	
	public static void getJavaScriptExecutorClick(WebDriver driver,WebElement element){

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		
		
	}
	public void getActionsClick(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		
	}
	
	public static void getElementActive(WebDriver driver,String id){

		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement actualYahooId = (WebElement)jse.executeScript("return document.getElementById('"+id+"');");
		WebElement expectedYahooId = (WebElement)jse.executeScript("return document.activeElement;");
			}

}
