package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@testOutput/failedTests/failedScenario.txt",
        glue = "com.automation.steps",
        plugin = "rerun:testOutput/failedTests/failedScenario.txt"
)
public class FailedTestRunner {

}

