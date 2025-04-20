package com.aniket.Runners;

import org.testng.annotations.BeforeClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/resources/features",
glue = {"com.aniket.stepDefinitions"},
plugin = {"pretty","html:target/Report/cucumber-reports.html"})
public class TestRunner extends AbstractTestNGCucumberTests {  
    @BeforeClass
    public static void beforeClass() {
        System.out.println("Starting Cucumber Tests...");  
    }
}
