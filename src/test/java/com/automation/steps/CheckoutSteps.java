package com.automation.steps;

import com.automation.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutSteps {

    CheckoutPage checkoutPage = new CheckoutPage();

    @Then("verify checkout page is displayed")
    public void verifyCheckoutPageIsDisplayed() {
        Assert.assertTrue(checkoutPage.isCheckoutPageDisplayed());
    }

    @When("user fills the {string}, {string} and {string} details")
    public void userFillsTheDetails(String firstName, String lastName, String zipCode) {
        checkoutPage.fillDetails(firstName, lastName, zipCode);
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        checkoutPage.clickOnContinueBtn();
    }

    @Then("verify Error message displayed")
    public void verifyErrorMessageDisplayed() {
        Assert.assertTrue(checkoutPage.isErrorMessageDisplayed());
    }

}
