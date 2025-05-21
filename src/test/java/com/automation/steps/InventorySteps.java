package com.automation.steps;

import com.automation.pages.InventoryPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class InventorySteps {

    InventoryPage inventoryPage = new InventoryPage();
    static List<String> products;

    @Then("verify user successfully logged in")
    public void verifyUserSuccessfullyLoggedIn() {
        Assert.assertTrue(inventoryPage.isInventoryPageDisplayed());
    }

    @When("user click add to cart on a {string}")
    public void userClickAddToCartOnA(String name) {
        inventoryPage.clickOnAddToCartBtn(name);
    }

    @When("user adds the following products to the cart:")
    public void userAddsTheFollowingProductsToTheCart(DataTable dataTable) {
        products = dataTable.asList();
        for (String product : products) {
            inventoryPage.clickOnAddToCartBtn(product);
        }
        inventoryPage.clickOnCartIcon();
    }

    @When("user adds the {string} to the cart")
    public void userAddsTheToTheCart(String productName) {
        inventoryPage.addProductToTheCart(productName);
    }

    @When("user removes the {string} from the cart")
    public void userRemovesTheFromTheCart(String product) {
        inventoryPage.removeProductFromTheCart(product);
    }

    @And("navigates to the cart page")
    public void navigatesToTheCartPage() {
        inventoryPage.clickOnCartIcon();
    }

    @Then("verify user is on inventory page")
    public void verifyUserIsOnInventoryPage() {
        Assert.assertTrue(inventoryPage.isInventoryPageDisplayed());
    }

    @When("user clicks on hamburger button")
    public void userClicksOnHamburgerButton() {
        inventoryPage.clickOnHamburgerMenu();
    }

    @And("clicks logout")
    public void clicksLogout() {
        inventoryPage.clickOnLogoutBtn();
    }

    @When("user clicks on the sort button")
    public void userClicksOnTheSortButton() {
        inventoryPage.clickOnSortBtn();
    }

    @And("selects sort by - {string}")
    public void selectsSortBy(String option) {
        inventoryPage.selectSortOption(option);
    }

    @Then("verify products are sorted by {string}")
    public void verifyProductsAreSortedByPriceLowToHigh(String option) {
        Assert.assertTrue(inventoryPage.isProductsSorted(option));
    }

    @When("user clicks on {string}")
    public void userClicksOn(String productName) {
        inventoryPage.clickOnProductTitle(productName);
    }

    @Then("verify menu options are displayed")
    public void verifyMenuOptionsAreDisplayed() {
        Assert.assertTrue(inventoryPage.isMenuOptionsDisplayed());
    }

    @And("clicks on reset app state")
    public void clicksOnResetAppState() {
        inventoryPage.clickOnRestAppState();
    }
}
