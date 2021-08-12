package com.selenium.practice.interview;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class variAndValidation {
static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();// upcasting
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://www.UPS.com/");
		 if(driver.getTitle().equalsIgnoreCase("Global Home: UPS - United States")) {
			   System.out.println("Test Passed");
		   }
		   else {
			   System.out.println("Test Failed");
		   }
		   
		 Assert.assertEquals( driver.getTitle(), "Global Home: UPS - United States");


	}

}
