package com.selenium.practice.interview;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class WindowHandleInSelenium {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();// upcasting
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> allwindows= driver.getWindowHandles();
		for(String window:allwindows) {

			if (!MainWindow.equalsIgnoreCase(window)) {
				TimeUnit.SECONDS.sleep(2);
				// Switching to Child window
				driver.switchTo().window(window);

				TimeUnit.SECONDS.sleep(2);
				driver.findElement(By.name("emailid")).sendKeys("sarowerny@gmail.com");

				driver.findElement(By.name("btnLogin")).click();
				TimeUnit.SECONDS.sleep(5);
				// Closing the Child Window.
				driver.close();
			}
		}
		TimeUnit.SECONDS.sleep(5);
		// Switching to Parent window i.e Main Window.
		driver.switchTo().window(MainWindow);
		
		
		TimeUnit.SECONDS.sleep(3);
		driver.quit();
	}
}
