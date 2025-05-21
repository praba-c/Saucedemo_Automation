package com.automation.steps;

import com.automation.pages.BasePage;
import com.automation.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    @Given("user opens application")
    public void userOpensApplication() {
        basePage.openWebsite();
    }

    @Then("verify login page is displayed")
    public void verifyLoginPageIsDisplayed() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @When("user enters username as {string} and password as {string}")
    public void userEntersUsernameAsAndPasswordAs(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @And("clicks login button")
    public void clicksLoginButton() {
        loginPage.clickOnLoginBtn();
    }

    @Then("verify error message displayed")
    public void verifyErrorMessageDisplayed() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Then("verify user successfully logged out")
    public void verifyUserSuccessfullyLoggedOut() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

}
