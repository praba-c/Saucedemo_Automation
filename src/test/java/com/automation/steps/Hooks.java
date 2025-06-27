package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.automation.utils.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

    @Before
    public void start() {
        ConfigReader.initConfig();
        DriverManager.createDriver();
    }

    @After
    public void clean(Scenario scenario) {
        boolean status = scenario.isFailed();
        scenario.attach(Screenshot.takeScreenshot(DriverManager.getDriver(), scenario.getName(), status), "image/png", "SCREENSHOT");
        Screenshot.takeFullPageScreenshot(DriverManager.getDriver(), scenario.getName());
        DriverManager.getDriver().quit();
    }
}
