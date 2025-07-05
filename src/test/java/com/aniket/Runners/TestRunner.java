package com.aniket.Runners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.aniket.Utils.ReportPathInitializer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features",
glue = {"com.aniket.stepDefinitions"},
tags = "@AddEmployee",
//dryRun=true,
plugin = {"pretty",
    "html:target/Report/cucumber-reports.html",
    "rerun:target/failed_scenarios.txt",
    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
)
public class TestRunner extends AbstractTestNGCucumberTests {  
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
    
}
