package com.aniket.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aniket.Manager.PageObjectManager;
import com.aniket.TestContext.TestContext;
import com.aniket.Utils.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutSteps {
     private WebDriver driver;
    private PageObjectManager pageObjectManager;

    public LogoutSteps(TestContext testContext) {
        this.driver = testContext.getDriver();
        this.pageObjectManager = testContext.getPageObjectManager();
    }

    @Given("User is logged in")
    public void user_is_logged_in() {
        String URL = ConfigReader.get("app.url");
        driver.get(URL);
        String username= ConfigReader.get("username");
        String password=ConfigReader.get("password");
        pageObjectManager.getLoginPageActions().loginToApp(username, password);
    }
    @When("User clicks on user dropdown")
    public void user_clicks_on_user_dropdown() {
        pageObjectManager.getHomePageActions().clickUserDropdown();
    }
    @When("click on logout button")
    public void click_on_logout_button() {
        pageObjectManager.getHomePageActions().clickLogoutButton();
    }
    @Then("user should be redirected to the login page")
    public void user_should_be_redirected_to_the_login_page() {
        boolean isLoginPageLoaded = pageObjectManager.getLoginPageActions().isLoginPageLoaded();
        Assert.assertTrue(isLoginPageLoaded,"Login page is not loaded");
    }
}
