package com.aniket.TestContext;

import org.openqa.selenium.WebDriver;

import com.aniket.Manager.PageObjectManager;

import io.cucumber.java.Scenario;

public class TestContext {
    private WebDriver driver;
    private PageObjectManager pageObjectManager;
    private Scenario scenario;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setPageObjectManager(PageObjectManager pageObjectManager) {
        this.pageObjectManager = pageObjectManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public void setScenario(Scenario scenario){
        this.scenario=scenario;
    }

    public Scenario getScenario(){
        return scenario;
    }
}
