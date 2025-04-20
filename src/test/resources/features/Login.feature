Feature: Login Functonality
    Scenario: Successfull login with valid credentials
        Given User is on login page
        When user enters username "Admin" and password "admin123"
        And clicks on login button
        Then user should navigated to home page
    
    Scenario: Unsuccessfull login with invalid credentials
        Given User is on login page
        When user enters username "Admin" and password "InvalidPass"
        And clicks on login button
        Then user should navigated to home page