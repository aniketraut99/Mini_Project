package com.aniket.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aniket.Manager.PageObjectManager;
import com.aniket.TestContext.TestContext;
import com.aniket.base.baseTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps  {

    private WebDriver driver;
private PageObjectManager pageObjectManager;

public LoginSteps(TestContext testContext) {
    this.driver = testContext.getDriver();
    this.pageObjectManager = testContext.getPageObjectManager();
}

    @Given("User is on login page")
    public void User_is_on_login_page(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user enters username {string} and password {string}")
    public void user_enter_credentials(String username, String Password){
        pageObjectManager.getLoginPageActions().enterUsername(username);
        pageObjectManager.getLoginPageActions().enterPassword(Password);
    }

    @And("clicks on login button")
    public void clicks_on_login_button(){
        pageObjectManager.getLoginPageActions().clickLogin();
    }
    @Then("user should navigated to home page")
    public void user_should_navigated_to_home_page() throws InterruptedException{
        Thread.sleep(5000);
        boolean isLoaded = pageObjectManager.getHomePageActions().isHomePageLoaded();
        if(isLoaded){
            System.out.println("Page Loaded successfully");
        } else{
            System.out.println("Page not loaded");
        }
    }
    
}
