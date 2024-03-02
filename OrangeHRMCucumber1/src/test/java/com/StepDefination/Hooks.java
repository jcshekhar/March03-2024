package com.StepDefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	public static WebDriver driver;

	@Before
	public static void setUp()
	{
	driver = new ChromeDriver();
	driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard");
	Log.info(" *** Chrome Browser Launched Successfully ********");

	}

	@After
	public static void tearDown()
	{
	driver.quit();
	Log.info(" *****  Successfully Close the Browser along with OrangeHRM Application ");

	}

}
