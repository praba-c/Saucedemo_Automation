package com.automation.utils;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static byte[] takeScreenshot(WebDriver driver, String name, boolean status) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String fileName = name + ".png";
        try {
            if (!status)
                FileUtils.copyFile(file, new File("screenshots/passedTests/" + fileName));
            else
                FileUtils.copyFile(file, new File("screenshots/failedTests/" + fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return takesScreenshot.getScreenshotAs(OutputType.BYTES);
    }

    public static void takeFullPageScreenshot(WebDriver driver, String name) {
        Shutterbug.shootPage(driver, Capture.FULL, true)
                .withName(name).save("fullPageScreenshots/");
    }
}