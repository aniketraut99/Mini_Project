package com.aniket.stepDefinitions;

import java.io.IOException;

import com.aniket.TestContext.TestContext;
import com.aniket.Utils.ExtentManager;
import com.aniket.Utils.ReportPathInitializer;
import com.aniket.Utils.TestUtil;
import com.aniket.base.baseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends baseTest{

    private final TestContext context;
    private static ExtentTest test;
    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setupHooks(Scenario scenario) throws IOException{
        setup();
        context.setDriver(getDriver());
        context.setPageObjectManager(pageObjectManager);
        context.setScenario(scenario);
        // Initialize ExtentReports and create a new test in the report
        test = ExtentManager.getInstance().createTest(scenario.getName());
        System.out.println("Setup Done using Hooks");
    }

    @After
    public void teardownHooks(Scenario scenario) throws IOException{
        if (scenario.isFailed()) {
            test.fail("Scenario failed");
            TestUtil.captureScreenshot(getDriver(), "test");
        } else {
            test.pass("Scenario passed");
        }
       teardown();
       ExtentManager.flush();
    }
}
