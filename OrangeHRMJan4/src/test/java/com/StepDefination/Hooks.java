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

	//System.setProperty("webdriver.chrome.driver","./browserDriverFiles/chromedriver.exe");
	driver = new ChromeDriver();

	Log.info(" *** Chrome Browser Launched Successfully ********");

	}

	@After
	public static void tearDown()
	{
	driver.quit();
	Log.info(" *****  Successfully Close the Browser along with OrangeHRM Application ");

	}
	
}


