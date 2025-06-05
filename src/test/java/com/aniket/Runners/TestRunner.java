package com.aniket.Runners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeClass;

import com.aniket.Utils.ReportPathInitializer;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features",
glue = {"com.aniket.stepDefinitions"},
tags = "@Login_Pass",
// dryRun=true,
plugin = {"pretty","html:target/Report/cucumber-reports.html",
 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
}
)
public class TestRunner extends AbstractTestNGCucumberTests {  
    
}
