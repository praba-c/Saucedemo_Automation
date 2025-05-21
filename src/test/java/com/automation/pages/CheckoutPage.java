package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//span[@class='title']")
    WebElement title;

    @FindBy(id = "first-name")
    WebElement firstNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    @FindBy(id = "postal-code")
    WebElement zipCodeInput;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    public boolean isCheckoutPageDisplayed() {
        return title.isDisplayed();
    }

    public void fillDetails(String firstName, String lastName, String zipCode) {
        firstNameInput.sendKeys(ConfigReader.getConfig(firstName));
        lastNameInput.sendKeys(ConfigReader.getConfig(lastName));
        zipCodeInput.sendKeys(ConfigReader.getConfig(zipCode));
    }

    public void clickOnContinueBtn() {
        continueBtn.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

}
