package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(id = "finish")
    WebElement finishBtn;

    public boolean isCheckoutOverviewPageDisplayed() {
        return finishBtn.isDisplayed();
    }

    public void clickOnFinishBtn() {
        finishBtn.click();
    }
}
