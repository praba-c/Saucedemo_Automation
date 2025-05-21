package com.automation.steps;

import com.automation.pages.CheckoutOverviewPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CheckoutOverviewSteps {

    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

    @Then ("verify checkout overview page is displayed")
    public void verifyCheckoutOverviewPageIsDisplayed() {
        Assert.assertTrue(checkoutOverviewPage.isCheckoutOverviewPageDisplayed());
    }

    @When("user clicks finish button")
    public void userClicksFinishButton() {
        checkoutOverviewPage.clickOnFinishBtn();
    }
}
