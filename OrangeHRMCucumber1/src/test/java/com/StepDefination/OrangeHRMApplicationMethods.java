package com.StepDefination;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class OrangeHRMApplicationMethods {
	
	public static WebDriver driver;
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";


	public OrangeHRMApplicationMethods(Hooks hook) // a Class name similar to Method name - its a constructor
{
	driver=Hooks.driver;
	}

	
	 @Given("^User should open the Browser in the System$") public void
	  user_should_open_the_Browser_in_the_System() {
	  
	  driver = new ChromeDriver();
	  
	  Log.info(" *** Chrome Browser Launched Successfully ********");
	  
	  
	  }
	 

	@When("^User enters Application Url Address$")
	public void user_enters_Application_Url_Address()
	{

	driver.get(applicationUrlAddress);

	Log.info(" Entered OrangeHRM Application Url Address ");

	driver.manage().window().maximize();

	// implicitlyWait - Its a global wait - this wait is going to be application to
//	                   each and every element of the WebPage to be identified with
//	                     the given property - which will wait for a maximum duration of
//	                       the given time
	//  implicitlyWait is a smart wait
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("^User should be navigated to OrangeHRM Application LogIn Page$")
	public void user_should_be_navigated_to_OrangeHRM_Application_LogIn_Page()
	{

	// id="logInPanelHeading"
	By logInPanelTextProperty=By.id("logInPanelHeading");
	WebElement orangeHRMApplication_LogInPageLogInPanel=driver.findElement(logInPanelTextProperty);

	String expected_orangeHRMApplication_LogInPageLogInPanelText="LOGIN Panel";
	Log.info(" The Expected Text of the OrangeHRM Application LogIn Page is :- "+expected_orangeHRMApplication_LogInPageLogInPanelText);

	String actual_orangeHRMApplication_LogInPageLogInPanelText=orangeHRMApplication_LogInPageLogInPanel.getText();
	Log.info(" The Actual Text of the OrangeHRM Application LogIn Page is :- "+actual_orangeHRMApplication_LogInPageLogInPanelText);

	if(actual_orangeHRMApplication_LogInPageLogInPanelText.equals(expected_orangeHRMApplication_LogInPageLogInPanelText))
	{
	Log.info(" Successfully navigated to OrangeHRM Application LogIn Page - PASS ");
	}
	else
	{
	Log.info(" Failed to navigat to OrangeHRM Application LogIn Page - FAIL ");
	}

	}

	@Then("^User should close the browser along with OrangeHRM Application$")
	public void user_should_close_the_browser_along_with_OrangeHRM_Application()
	{
	driver.quit();
	Log.info(" *****  Successfully Close the Browser along with OrangeHRM Application ");
	}
	@Then("^User should enter userName and password and click on login button$")
	public void user_should_enter_userName_and_password_and_click_on_login_button()
	{
	String userNameTestData="srini"; // Test data - which should be passed to sendKeys method
	By userNameProperty=By.id("txtUsername"); // idetifying the property of an element assigned to a variable
	// the property of the element should be identified in the WebPage
	WebElement userName=driver.findElement(userNameProperty); // WebElement is an interface of Selenium ( which can be treated as a dataType )
	// Performing an operation on the identified webElement
	userName.sendKeys(userNameTestData);

	Log.info(userNameTestData);

	// Automating Password WebElement
	// <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">

	String passwordTestData="Q@Trainer7"; // TestData
	By passwordProperty=By.name("txtPassword"); // identify the Property
	WebElement password=driver.findElement(passwordProperty); // identify the WebElement
	password.sendKeys(passwordTestData); // Operation on WebElement

	Log.info(passwordTestData);

	// <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	By logInButtonProperty=By.className("button");
	WebElement logInButton=driver.findElement(logInButtonProperty);
	logInButton.click();

	}



	@Then("^User should enter \"([^\"]*)\" and \"([^\"]*)\" and click on login button$")
	public void user_should_enter_and_and_click_on_login_button(String userName, String password)
	{
	//String userNameTestData="srini"; // Test data - which should be passed to sendKeys method
	By userNameProperty=By.id("txtUsername"); // idetifying the property of an element assigned to a variable
	// the property of the element should be identified in the WebPage
	WebElement logInPageUserName=driver.findElement(userNameProperty); // WebElement is an interface of Selenium ( which can be treated as a dataType )
	// Performing an operation on the identified webElement
	logInPageUserName.sendKeys(userName);

	Log.info(userName);

	// Automating Password WebElement
	// <input name="txtPassword" id="txtPassword" autocomplete="off" type="password">

	//String passwordTestData="Q@Trainer7"; // TestData
	By passwordProperty=By.name("txtPassword"); // identify the Property
	WebElement logInPagePassword=driver.findElement(passwordProperty); // identify the WebElement
	logInPagePassword.sendKeys(password); // Operation on WebElement

	Log.info(password);

	// <input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
	By logInButtonProperty=By.className("button");
	WebElement logInButton=driver.findElement(logInButtonProperty);
	logInButton.click();

	}
	By welComeAdminProperty;
	WebElement welComeAdmin;

	@Then("^User should be navigated to OrangeHRM Application HomePage$")
	public void user_should_be_navigated_to_OrangeHRM_Application_HomePage()
	{
	// Validating OrangeHRM Application HomePage

	String expected_OrangeHRMApplicationHomePageText="Welcome";
	// System.out.println(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

	Log.info(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);

	// <a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>

	//By welComeAdminProperty=By.linkText("Welcome Admin");
	welComeAdminProperty=By.id("welcome");
	welComeAdmin=driver.findElement(welComeAdminProperty);

	String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
	//System.out.println(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);

	Log.info(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);


	if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
	{
	//System.out.println(" Successfully Navigated to OrangeHRM Application HomePage - PASS");
	Log.info(" Successfully Navigated to OrangeHRM Application HomePage - PASS");
	}
	else
	{
	// System.out.println(" Failed to Navigate to OrangeHRM Application HomePage - FAIL");
	Log.info(" Failed to Navigate to OrangeHRM Application HomePage - FAIL");
	}


	}

	@Then("^User should click on WelCome Admin$")
	public void user_should_click_on_WelCome_Admin()
	{
	welComeAdmin.click();
	Log.info(" Performed Click Operation on WelCome Admin ");

	}

	@Then("^User should click on logOut$")
	public void user_should_click_on_logOut() throws InterruptedException
	{
	//Thread.sleep(10000);
	   
	By logOutProperty=By.linkText("Logout");
	WebElement logOut=driver.findElement(logOutProperty);
	logOut.click();

	Log.info(" Successfully LogOut from the Application ");
	}
	}


	
