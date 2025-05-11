package com.aniket.base;


import java.io.ObjectInputFilter.Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aniket.Manager.PageObjectManager;
import com.aniket.Utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
    private WebDriver driver;
    public PageObjectManager pageObjectManager;
    @BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
    	options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        pageObjectManager = new PageObjectManager(driver);
        ConfigReader.loadConfig("config");
        
    }
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}
