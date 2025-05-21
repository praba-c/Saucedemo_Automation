package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage {

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement orderConfirmationMsg;

    public boolean isOrderConfirmationPageDisplayed() {
        if(orderConfirmationMsg.isDisplayed()) {
            System.out.println(orderConfirmationMsg.getText());
            return true;
        }
        return false;
    }
}
