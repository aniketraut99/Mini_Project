@Logout
Feature:Logout Functionality
    Scenario: User log out Successfully
        Given User is logged in
        When User clicks on user dropdown
        And click on logout button
        Then user should be redirected to the login page