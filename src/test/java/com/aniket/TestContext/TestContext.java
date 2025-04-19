package com.aniket.TestContext;

import org.openqa.selenium.WebDriver;

import com.aniket.Manager.PageObjectManager;

public class TestContext {
    private WebDriver driver;
    private PageObjectManager pageObjectManager;

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
}
