package com.automation.steps;

import com.automation.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.automation.steps.InventorySteps.products;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @Then("verify product added to the cart")
    public void verifyProductAddedToTheCart() {
        for (String product : products) {
            Assert.assertTrue(cartPage.verifyProductAddedToTheCart(product));
        }
    }

    @Then("verify {string} removed from the cart")
    public void verifyRemovedFromTheCart(String product) {
        Assert.assertTrue(cartPage.verifyProductRemoveFromTheCart(product));
    }

    @Then("verify cart page displayed")
    public void verifyCartPageDisplayed() {
        Assert.assertTrue(cartPage.isCartPageDisplayed());
    }

    @And("print the details of the product in the cart")
    public void printTheDetailsOfTheProductInTheCart() {
        cartPage.printDetails();
    }

    @When("user selects continue shopping")
    public void userSelectsContinueShopping() {
        cartPage.clickOnContinueShoppingBtn();
    }

    @When("user clicks checkout button")
    public void userClicksCheckoutButton() {
        cartPage.clickOnCheckoutBtn();
    }
}
