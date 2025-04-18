package com.aniket.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aniket.Manager.PageObjectManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseTest {
    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    @BeforeClass
    public void setup(){
        //driver = new ChromeDriver();
        //options.addArguments("--headless");
        ChromeOptions options = new ChromeOptions();
    	options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        pageObjectManager = new PageObjectManager(driver);
        
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    
}
