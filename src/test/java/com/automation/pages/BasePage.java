package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    static WebDriver driver;
    static WebDriverWait wait;

    public BasePage(){
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void openWebsite() {
        driver.get(ConfigReader.getConfig("application.url"));
    }

    public double stringPriceValueToDouble(String price) {
        if (price.isEmpty()) {
            return 0;
        }
        String priceValue = price.replace("$", "");
        return Double.parseDouble(priceValue.trim());
    }

    public boolean isDisplayed(WebElement element) {
        setImplicitWait(0);
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        } finally {
            setImplicitWait(60);
        }
    }

    public void setImplicitWait(long secs) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(secs));
    }
}
