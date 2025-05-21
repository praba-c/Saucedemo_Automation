package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement title;

    @FindBy(id = "back-to-products")
    WebElement backToProductsBtn;

    public boolean isProductDetailsPageDisplayed() {
        System.out.println("Product - " + title.getText());
        return title.isDisplayed();
    }

    public void clickBackToProducts() {
        backToProductsBtn.click();
    }
}
