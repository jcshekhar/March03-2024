Feature: OrangeHRM Applicatin Functionalities Testing

Background:
Given User should open the Browser in the System
@SmokeTest
Scenario: Validating OrangeHRM Application LogIn Page Test


When User enters Application Url Address
Then User should be navigated to OrangeHRM Application LogIn Page
#Then User should close the browser along with OrangeHRM Application


@ReTesting
Scenario: Validating OrangeHRM Application LogIn Funcationality Test

Given User should open the Browser in the System
When User enters Application Url Address
Then User should be navigated to OrangeHRM Application LogIn Page
Then User should enter userName and password and click on login button
Then User should be navigated to OrangeHRM Application HomePage
Then User should click on WelCome Admin
Then User should click on logOut
Then User should be navigated to OrangeHRM Application LogIn Page
#Then User should close the browser along with OrangeHRM Application

@LogInTestWIthTestData
Scenario Outline: Validating OrangeHRM Application LogIn Funcationality Test with Multiple TestData

#Given User should open the Browser in the System
When User enters Application Url Address
Then User should be navigated to OrangeHRM Application LogIn Page
Then User should enter "<userName>" and "<password>" and click on login button
Then User should be navigated to OrangeHRM Application HomePage
Then User should click on WelCome Admin
Then User should click on logOut
#Then User should close the browser along with OrangeHRM Application

Examples:
|   userName   |    password     |
|   Admin      |    Chandu123@01 |
|   srini      |    Q@Trainer    |
|   Hello      |    Chandu123@01 |
|   Admin      |    Chandu123@01 |
 
