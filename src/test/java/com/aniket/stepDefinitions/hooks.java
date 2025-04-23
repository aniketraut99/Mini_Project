package com.aniket.stepDefinitions;

import com.aniket.TestContext.TestContext;
import com.aniket.base.baseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks extends baseTest{

    private final TestContext context;
    public hooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setupHooks(){
        setup();
        context.setDriver(driver);
        context.setPageObjectManager(pageObjectManager);
        System.out.println("Setup Done using Hooks");
    }

    @After
    public void teardownHooks(){
       teardown();
    }
}
