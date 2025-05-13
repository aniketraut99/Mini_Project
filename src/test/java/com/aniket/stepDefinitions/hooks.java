package com.aniket.stepDefinitions;

import com.aniket.TestContext.TestContext;
import com.aniket.Utils.ExtentManager;
import com.aniket.base.baseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks extends baseTest{

    private final TestContext context;
    private static ExtentTest test;
    public hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setupHooks(Scenario scenario){
        setup();
        context.setDriver(getDriver());
        context.setPageObjectManager(pageObjectManager);
        // Initialize ExtentReports and create a new test in the report
        test = ExtentManager.getInstance().createTest(scenario.getName());
        System.out.println("Setup Done using Hooks 1");
    }

    @After
    public void teardownHooks(Scenario scenario){
        if (scenario.isFailed()) {
            test.fail("Scenario failed");
        } else {
            test.pass("Scenario passed");
        }
       teardown();
       ExtentManager.flush();
    }
}
