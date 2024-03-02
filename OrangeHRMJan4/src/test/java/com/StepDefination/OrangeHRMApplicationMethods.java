package com.StepDefination;

import java.util.concurrent.TimeUnit;

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

	
	public OrangeHRMApplicationMethods(Hooks hook) // a Class name similar to Method name - its a constructor
	{
	driver=hook.driver;
	}

	@Given("User should open the Browser in the System")
	public void user_should_open_the_browser_in_the_system() {
		driver = new ChromeDriver();
		//driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login");
		Log.info("Browser Lunched Successfully");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@When("User enters Application Url Address")
	public void user_enters_application_url_address() {
	Log.info("Wel Come To Login Page");
	
	}
	@Then("User should be navigated to OrangeHRM Application LogIn Page")
	public void user_should_be_navigated_to_orange_hrm_application_log_in_page() {
	WebElement Text = driver.findElement(By.id("logInPanelHeading"));
	String T = Text.getText();
	Log.info("LoginPannel is Captured Sucessfully ="+ T);
	}
	
	@Then("User should enter userName and password and click on login button")
	public void user_should_enter_user_name_and_password_and_click_on_login_button() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Chandu123@01");
		driver.findElement(By.id("btnLogin")).click();
		Log.info("Login Detials are Correct");
		
	}
	@Then("User should be navigated to OrangeHRM Application HomePage")
	public void user_should_be_navigated_to_orange_hrm_application_home_page() {
		WebElement DashBoard = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/h1"));
		String DBText = DashBoard.getText();
		Log.info("Welcome to DashBoard :"+DBText);
	}
	@Then("User should click on WelCome Admin")
	public void user_should_click_on_wel_come_admin() {
		driver.findElement(By.id("welcome")).click();
		Log.info("Welcome Menu Access succesfully");
	}
	@Then("User should click on logOut")
	public void user_should_click_on_log_out() {
		driver.findElement(By.partialLinkText("Logout")).click();
	}
	@Then("^User should enter \"([^\"]*)\" and \"([^\"]*)\" and click on login button$")
	public void user_should_enter_and_and_click_on_login_button(String userName, String password) {
		
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
	
		
	@Then("User should close the browser along with OrangeHRM Application")
	public void user_should_close_the_browser_along_with_orange_hrm_application() {
	Log.info("Completed the Operation");
	//driver.quit();
	}
	
}
