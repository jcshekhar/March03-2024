Feature: OrangeHRM Applicatin Functionalities Testing

Scenario: Validating OrangeHRM Application LogIn Page Test

Given User should open the Browser in the System
When User enters Application Url Address
Then User should be navigated to OrangeHRM Application LogIn Page
Then User should close the browser along with OrangeHRM Application

Scenario: Validating OrangeHRM Application LogIn Funcationality Test

Given User should open the Browser in the System
When User enters Application Url Address
Then User should be navigated to OrangeHRM Application LogIn Page
Then User should enter userName and password and click on login button
Then User should be navigated to OrangeHRM Application HomePage
Then User should click on WelCome Admin
Then User should click on logOut
Then User should be navigated to OrangeHRM Application LogIn Page
Then User should close the browser along with OrangeHRM Application