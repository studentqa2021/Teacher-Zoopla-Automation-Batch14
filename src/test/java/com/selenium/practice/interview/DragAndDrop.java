package com.selenium.practice.interview;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();// upcasting
		driver.manage().window().maximize(); //
		 
		// Open webpage
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		 
		// Add 5 seconds wait
		Thread.sleep(5000);
		 
		// Create object of actions class
		Actions act=new Actions(driver);//1
		 
		// find element which we need to drag
		WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));//2
		 
		// find element which we need to drop
		WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));//3
		 
		// this will drag element to destination
		act.dragAndDrop(drag, drop).perform();//4
		// driver.quit();;

	}

}
