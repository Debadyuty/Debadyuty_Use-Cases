@Smoke
Feature: Login Functionality

Background:
    Given user launches browser
    And user opens login page

@Smoke
Scenario: Valid Login
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks login button
    Then user should navigate to dashboard

@Regression
Scenario: Invalid Login
    When user enters username "test"
    And user enters password "wrong123"
    And user clicks login button
    Then user should see error message