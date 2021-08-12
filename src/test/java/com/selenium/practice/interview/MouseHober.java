package com.selenium.practice.interview;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.util.Highlighter;

public class MouseHober {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();// upcasting
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.costco.com/");

		

		List<WebElement> element = driver.findElements(By.xpath("//*[@class='nav-item']//a"));
		Highlighter.addColor(driver, element.get(2));
		Thread.sleep(2500);
		Actions action = new Actions(driver);

		action.moveToElement(element.get(2)).build().perform();
		
		

		//element.get(2).click();

	}

}
