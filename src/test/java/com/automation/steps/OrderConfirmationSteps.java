package com.automation.steps;

import com.automation.pages.OrderConfirmationPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class OrderConfirmationSteps {

    OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();

    @Then("verify order confirmation page is displayed")
    public void verifyOrderConfirmationPageIsDisplayed() {
        Assert.assertTrue(orderConfirmationPage.isOrderConfirmationPageDisplayed());
    }
}
