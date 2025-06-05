package com.aniket.testng_demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aniket.Utils.ExtentManager;
import com.aniket.base.baseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SmartBank extends baseTest {
    private WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @Test
    public void Valid_Registration() throws InterruptedException{
    driver = getDriver();
    ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
    extent = new ExtentReports();
    extent.attachReporter(sparkReporter);
    ExtentTest test1 = extent.createTest("Login Test");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOf(element));

    driver.get("file:///C:/Users/Admin/Downloads/TestingTest_Manual&Automation%20(1)%20(1)/TestingTest_Manual&Automation/SmartBank.html");
    Thread.sleep(3000);
    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("regName"))));
    driver.findElement(By.id("regName")).sendKeys("Testing 123");
    driver.findElement(By.id("regEmail")).sendKeys("test@test.com");
    driver.findElement(By.id("regPassword")).sendKeys("Password@123");
    driver.findElement(By.id("regConfirmPassword")).sendKeys("Password@123");

    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[text()='Register']"))));
    driver.findElement(By.xpath("//button[text()='Register']")).click();   
    
    extent.flush();
    }
}
