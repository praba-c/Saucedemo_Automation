Feature: Validate Login Functionalities

  Background:
    Given user opens application
    Then verify login page is displayed

  Scenario: Login with valid credentials
    When user enters username as "standard_user" and password as "secret_sauce"
    And clicks login button
    Then verify user successfully logged in

  Scenario: Login with invalid credentials
    When user enters username as "fake_user" and password as "fake_pass"
    And clicks login button
    Then verify error message displayed

  Scenario: Login with locked out user
    When user enters username as "locked_out_user" and password as "secret_sauce"
    And clicks login button
    Then verify error message displayed

  Scenario: User logging out from the application
    When user enters username as "standard_user" and password as "secret_sauce"
    And clicks login button
    Then verify user successfully logged in
    When user clicks on hamburger button
    And clicks logout
    Then verify user successfully logged out