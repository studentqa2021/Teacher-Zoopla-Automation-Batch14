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
		driver.get("https://www.costco.com/");

		
// how to handle multiple elements in selenium?
		List<WebElement> element = driver.findElements(By.xpath("//*[@class='nav-item']"));
		//List = java collection framework
		// how to add object in list==>add()
		// total no ==> size()
		// go to any specific object or element from a list ==>list object.get(index)
		//optical =4 || index =3 ==> list object.get(3)
		Highlighter.addColor(driver, element.get(3));
		Thread.sleep(2500);
		Actions action = new Actions(driver);

		action.moveToElement(element.get(3)).build().perform();
	

	}

}
