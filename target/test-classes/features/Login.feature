Feature: Login Functonality
    @regression
    Scenario: Successfull login with valid credentials
        Given User is on login page
        When user enters username "Admin" and password "admin123"
        And clicks on login button
        Then user should navigated to home page
    
    Scenario: Unsuccessfull login with invalid credentials
        Given User is on login page
        When user enters username "gfjhfig" and password "InvalidPass"
        And clicks on login button
        Then user should get error message

    Scenario: Login with empty fields
        Given User is on login page
        When user enters username "tesr" and password ""
        When clicks on login button
        Then user should see "Required" validation messages