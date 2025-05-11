package com.aniket.testng_demo;

import java.io.IOException;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aniket.Pages.Actions.LoginPageActions;
import com.aniket.Utils.TestUtil;
import com.aniket.base.baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testng_demo extends baseTest{
    private WebDriver driver;


    @Test
    public void Login() throws InterruptedException, IOException{
        driver = getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        pageObjectManager.getLoginPageActions().loginToApp("Admin", "admin123");
        Boolean isLoaded = pageObjectManager.getHomePageActions().isHomePageLoaded();
        if (isLoaded) {
            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Page Title: " + driver.getCurrentUrl());
        } else {
            System.out.println("failed to load home page");
        }
        TestUtil.captureScreenshot(driver,"Login");
        
    }
    @Test
    public void LoginToFB() throws IOException{
        
        driver.get("https://www.facebook.com");
        System.out.println("Page Title: " + driver.getTitle());
        TestUtil.captureScreenshot(driver,"LoginToFB");
    }

    //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
}