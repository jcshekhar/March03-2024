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
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
	@Given("User should open the Browser in the System")
	public void user_should_open_the_browser_in_the_system() {
		//System.setProperty("webdriver.chrome.driver","C:\\eclipseWorkSpace\\OHRMACucumber\\webDrivers\\chromedriver.exe");
		driver = new ChromeDriver(); 
	}
	@When("User enters Application Url Address")
	public void user_enters_application_url_address() {
		driver.get(applicationUrlAddress);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("User should be navigated to OrangeHRM Application LogIn Page")
	public void user_should_be_navigated_to_orange_hrm_application_log_in_page() {
		
		// id="logInPanelHeading"
		By logInPanelTextProperty=By.cssSelector("#logInPanelHeading");
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
	@Then("User should close the browser along with OrangeHRM Application")
	public void user_should_close_the_browser_along_with_orange_hrm_application() {
		driver.quit();
		Log.info(" *****  Successfully Close the Browser along with OrangeHRM Application ");
	}

	@Then("User should enter userName and password and click on login button")
	public void user_should_enter_user_name_and_password_and_click_on_login_button() {
	    
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Chandu123@01");
		driver.findElement(By.id("btnLogin")).click();
		Log.info("********Login Successfully completed**********");
		
	}
	By welComeAdminProperty;
	WebElement welComeAdmin;
	@Then("User should be navigated to OrangeHRM Application HomePage")
	public void user_should_be_navigated_to_orange_hrm_application_home_page() {	   
		String expected_OrangeHRMApplicationHomePageText="Welcome";
		Log.info(" The Expected Text of the OrangeHRM Application HomePage is :- "+expected_OrangeHRMApplicationHomePageText);
		welComeAdminProperty=By.id("welcome");
		welComeAdmin=driver.findElement(welComeAdminProperty);
		String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
		Log.info(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);
		if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
		{
		Log.info(" Successfully Navigated to OrangeHRM Application HomePage - PASS");
		}
		else
		{
		Log.info(" Failed to Navigate to OrangeHRM Application HomePage - FAIL");
		}	
	}
	@Then("User should click on WelCome Admin")
	public void user_should_click_on_wel_come_admin() {
	   
		driver.findElement(By.xpath("//a[@id='welcome']")).click();	
		Log.info("******WelCome************");
	}
	@Then("User should click on logOut")
	public void user_should_click_on_log_out() throws InterruptedException {
		////*[@id="welcome-menu"]/ul/li[3]/a
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Logout")).click();;
	  // driver.findElement(By.linkText("Logout"));
	   Log.info("*************Logout is Completed********");	
	}
	
}
