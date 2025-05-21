package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPage extends BasePage {

    @FindBy(xpath = "//div[@data-test='inventory-item-name']")
    List<WebElement> productList;

    @FindBy(xpath = "//div[@data-test='inventory-item-price']")
    List<WebElement> priceList;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartIconQty;

    @FindBy(className = "product_sort_container")
    WebElement sortBtn;

    @FindBy(xpath = "//select[@class='product_sort_container']/option")
    List<WebElement> sortOptions;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutBtn;

    @FindBy(xpath = "//nav[@class='bm-item-list']/a")
    WebElement menuOptions;

    @FindBy(id = "reset_sidebar_link")
    WebElement resetAppStateBtn;

    public boolean isInventoryPageDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(productList.getFirst()));
        return productList.getFirst().isDisplayed();
    }

    public void addProductToTheCart(String productName) {
        for (WebElement product : productList) {
            if (product.getText().equalsIgnoreCase(ConfigReader.getConfig(productName))) {
                if (product.findElement(By.xpath("ancestor::div[2]//button")).getText().equalsIgnoreCase("add to cart")) {
                    product.findElement(By.xpath("ancestor::div[2]//button")).click();
                } else {
                    System.out.println(productName + " is already in the cart");
                }
            }
        }
        cartIcon.click();
    }

    public void removeProductFromTheCart(String productName) {
        for (WebElement product : productList) {
            if (product.getText().equalsIgnoreCase(ConfigReader.getConfig(productName))) {
                if (product.findElement(By.xpath("ancestor::div[2]//button")).getText().equalsIgnoreCase("remove")) {
                    product.findElement(By.xpath("ancestor::div[2]//button")).click();
                } else {
                    System.out.println(productName + " is not in the cart");
                }
            }
        }
        cartIcon.click();
    }

    public void clickOnAddToCartBtn(String productName) {
        for (WebElement product : productList) {
            if (product.getText().equalsIgnoreCase(productName)) {
                product.findElement(By.xpath("ancestor::div[2]//button")).click();
            }
        }
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void clickOnHamburgerMenu() {
        menuBtn.click();
    }

    public void clickOnLogoutBtn() {
        logoutBtn.click();
    }

    public void clickOnSortBtn() {
        sortBtn.click();
    }

    public void selectSortOption(String option) {
        for (WebElement element : sortOptions) {
            if (element.getText().equalsIgnoreCase(ConfigReader.getConfig(option))) {
                element.click();
                break;
            }
        }
    }

    public boolean isProductsSorted(String option) {

        List<String> list = new ArrayList<>();
        for (WebElement element : productList) {
            list.add(element.getText());
        }
        Collections.sort(list);

        if (ConfigReader.getConfig(option).equalsIgnoreCase("price (low to high)")) {
            for (int i = 1; i < priceList.size(); ++i) {
                double prev = stringPriceValueToDouble(priceList.get(i - 1).getText());
                double curr = stringPriceValueToDouble(priceList.get(i).getText());

                if (curr < prev) {
                    return false;
                }
            }
        } else if (ConfigReader.getConfig(option).equalsIgnoreCase("price (high to low)")) {
            for (int i = 1; i < priceList.size(); ++i) {
                double prev = stringPriceValueToDouble(priceList.get(i - 1).getText());
                double curr = stringPriceValueToDouble(priceList.get(i).getText());

                if (curr > prev) {
                    return false;
                }
            }
        } else if (ConfigReader.getConfig(option).equalsIgnoreCase("name (a to z)")) {
            for (int i = 0; i < productList.size(); ++i) {
                if (!productList.get(i).getText().equals(list.get(i))) {
                    return false;
                }
            }
        } else {
            int j = 0;
            for (int i = productList.size() - 1; i >= 0; --i) {
                if (!productList.get(i).getText().equals(list.get(j++))) {
                    System.out.println(productList.get(i).getText() + "__" + list.get(i));
                    return false;
                }
            }
        }
        return true;
    }

    public void clickOnProductTitle(String name) {
        for (WebElement element : productList) {
            if (element.getText().equalsIgnoreCase(ConfigReader.getConfig(name))) {
                element.click();
                break;
            }
        }
    }

    public boolean isMenuOptionsDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(menuOptions));
        return menuOptions.isDisplayed();
    }

    public void clickOnRestAppState() {
        resetAppStateBtn.click();
    }
}
