Feature: Validate Cart page functionalities

  Background:
    Given user opens application
    Then verify login page is displayed
    When user enters username as "standard_user" and password as "secret_sauce"
    And clicks login button
    Then verify user successfully logged in

  Scenario: Add a single product to the cart
    When user adds the "product" to the cart

    @Smoke
  Scenario: Add many product to the cart
    When user adds the following products to the cart:
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
    Then verify product added to the cart

  Scenario: Remove product from cart
    And user adds the "product" to the cart
    When user removes the "product" from the cart
    Then verify "product" removed from the cart

  Scenario: Remove product from the cart
    When user adds the "product" to the cart
    And navigates to the cart page
    Then verify cart page displayed
    When user removes the "product" from the cart
    Then verify "product" removed from the cart

  Scenario: View cart contents
    When user adds the following products to the cart:
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
      | Sauce Labs Fleece Jacket |
    And navigates to the cart page
    Then verify cart page displayed
    And print the details of the product in the cart

  Scenario: Continue shopping from cart
    When user adds the "product" to the cart
    And navigates to the cart page
    Then verify cart page displayed
    When user selects continue shopping
    Then verify user is on inventory page