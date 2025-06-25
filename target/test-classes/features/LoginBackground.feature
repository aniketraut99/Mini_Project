@LoginWithBackground
Feature: Login Functonality with background keyword

    Background:
    Given User is on login page
    When user enters credentials
    And clicks on login button
    
    Scenario: Successfull login with valid credentials
        Then user should navigated to home page
    
    Scenario: Unsuccessfull login with invalid credentials
        Then user should get error message

    Scenario: Login with empty fields
        Then user should see "Required" validation messages