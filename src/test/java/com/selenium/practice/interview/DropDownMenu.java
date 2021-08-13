package com.selenium.practice.interview;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class DropDownMenu {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();// upcasting
		driver.manage().window().maximize(); //
		// Put an Implicit wait,
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the URL
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.findElement(By.xpath("//*[contains(text(),'REGISTER')]")).click();

		Select select = new Select(driver.findElement(By.name("country")));//element
		select.selectByVisibleText("AUSTRALIA");//application

		// Using sleep command so that changes can be noticed
		Thread.sleep(2000);

		// Step 5: Select option 'Africa' now (Use selectByVisibleText)
		select.selectByIndex(0);//Albania

		Thread.sleep(2000);
		select.selectByValue("ARGENTINA");//html

		Thread.sleep(2000);
		// Step 6: Print all the options for the selected drop down and select one
		// option of your choice
		// Get the size of the Select element
		List<WebElement> dropDownOptions = select.getOptions();//multiple

		System.out.println("Total drop down options = "+dropDownOptions.size());
// number =int==> get text of index value get(index).getText()
		// Setting up the loop to print all the options
		for (int i = 0; i < dropDownOptions.size(); i++) {
			// Storing the value of the option
			String value = select.getOptions().get(i).getText();
			// Printing the stored value
			System.out.println(value);
			// Putting a check on each option that if any of the option is equal to 'Africa"
			// then select it

//			if (value.equals("UNITED STATES")) {
//				select.selectByIndex(i);
//				break;
//			}

		}
		// Kill the browser
		driver.quit();

	}

}
