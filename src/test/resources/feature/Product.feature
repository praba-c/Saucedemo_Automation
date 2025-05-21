Feature: Validate Product page functionalities

  Background:
    Given user opens application
    Then verify login page is displayed
    When user enters username as "standard_user" and password as "secret_sauce"
    And clicks login button
    Then verify user successfully logged in

  Scenario: Sort products by price low to high
    When user clicks on the sort button
    And selects sort by - "sortOption-price"
    Then verify products are sorted by "sortOption-price"

  Scenario: Sort products by name Z to A
    When user clicks on the sort button
    And selects sort by - "sortOption-name"
    Then verify products are sorted by "sortOption-name"

  Scenario: View product detail
    When user clicks on "productName"
    Then verify product detail page is displayed

  Scenario: Navigate back to products from detail page
    When user clicks on "productName"
    Then verify product detail page is displayed
    When user clicks on back to products
    Then verify user is on inventory page

  Scenario: Verify burger menu options are displayed
    When user clicks on hamburger button
    Then verify menu options are displayed

  Scenario: Reset app state
    When user adds the "productName" to the cart
    And user clicks on hamburger button
    And clicks on reset app state
    Then verify "productName" removed from the cart