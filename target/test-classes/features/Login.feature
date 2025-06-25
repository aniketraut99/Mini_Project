@Login
Feature: Login Functonality
    @Login_Pass
    Scenario: Successfull login with valid credentials
        Given User is on login page
        When user enters credentials
        And clicks on login button
        Then user should navigated to home page
    
    Scenario: Unsuccessfull login with invalid credentials
        Given User is on login page
        When user enters credentials
        And clicks on login button
        Then user should get error message

    
    Scenario: Login with empty fields
        Given User is on login page
        #When user enters username "" and password ""
        When user enters credentials
        When clicks on login button
        Then user should see "Required" validation messages