package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//span[@class='title']")
    WebElement title;

    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    List<WebElement> productList;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingBtn;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    public boolean isCartPageDisplayed() {
        return title.isDisplayed();
    }

    public boolean verifyProductAddedToTheCart(String product) {
        for (WebElement pro : productList) {
            if (pro.getText().equalsIgnoreCase(product)) {
                return true;
            }
        }
        return false;
    }

    public boolean verifyProductRemoveFromTheCart(String product) {
        setImplicitWait(2);
        if (productList.isEmpty()) {
            setImplicitWait(60);
            return true;
        }

        for (WebElement pro : productList) {
            if (!pro.getText().equalsIgnoreCase(ConfigReader.getConfig(product))) {
                return true;
            }
        }
        setImplicitWait(60);
        return false;
    }

    public void printDetails() {
        for (WebElement element : productList) {
            System.out.println(element.findElement(By.xpath("../..")).getText().replace("Remove", " "));
        }
    }

    public void clickOnContinueShoppingBtn() {
        continueShoppingBtn.click();
    }

    public void clickOnCheckoutBtn() {
        checkoutBtn.click();
    }
}
