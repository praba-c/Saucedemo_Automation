package com.automation.steps;

import com.automation.pages.ProductDetailsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductDetailsSteps {

    ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @Then("verify product detail page is displayed")
    public void verifyProductDetailPageIsDisplayed() {
        Assert.assertTrue(productDetailsPage.isProductDetailsPageDisplayed());
    }

    @When("user clicks on back to products")
    public void userClicksOnBackToProducts() {
        productDetailsPage.clickBackToProducts();
    }
}
