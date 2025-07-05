package com.aniket.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "@target/failed_scenarios.txt",
glue = {"com.aniket.stepDefinitions"},
// tags = "",
//dryRun=true,
plugin = {"pretty",
    "html:target/Report/cucumber-reports.html",
    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
)
public class FailedTestRunner extends AbstractTestNGCucumberTests {
    
}
