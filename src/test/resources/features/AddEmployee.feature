@AddEmployee
Feature: Add employee

    Scenario: Add employee with valid details
        Given User is logged in
        When User navigates to PIM Page
        And clicks on Add Employee
        And enters first name and last name
        And clicks Save
        Then employee should be added and Personal Details page should be displayed