Feature: Validate checkout page features

  Background:
    Given user opens application
    Then verify login page is displayed
    When user enters username as "standard_user" and password as "secret_sauce"
    And clicks login button
    Then verify user successfully logged in
    When user adds the "product" to the cart
    And navigates to the cart page
    Then verify cart page displayed

  Scenario: Initiate checkout

    When user clicks checkout button
    Then verify checkout page is displayed

  Scenario: Checkouts with valid information

    When user clicks checkout button
    Then verify checkout page is displayed
    When user fills the "firstName", "lastName" and "zipCode" details
    And click on continue button
    Then verify checkout overview page is displayed

  Scenario: Checkout without zip code

    When user clicks checkout button
    Then verify checkout page is displayed
    When user fills the "firstName", "lastName" and "invalidZipCode" details
    And click on continue button
    Then verify Error message displayed

  Scenario: Finish checkout process

    When user clicks checkout button
    Then verify checkout page is displayed
    When user fills the "firstName", "lastName" and "zipCode" details
    And click on continue button
    Then verify checkout overview page is displayed
    When user clicks finish button
    Then verify order confirmation page is displayed
