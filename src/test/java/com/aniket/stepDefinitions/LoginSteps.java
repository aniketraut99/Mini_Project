package com.aniket.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import com.aniket.Manager.PageObjectManager;
import com.aniket.TestContext.TestContext;
import com.aniket.Utils.ConfigReader;
import com.aniket.Utils.ExcelReader;
import com.aniket.Utils.TestUtil;
import com.aniket.base.baseTest;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps  {

    private WebDriver driver;
    private PageObjectManager pageObjectManager;
    private Scenario scenario;

    public LoginSteps(TestContext testContext) {
        this.driver = testContext.getDriver();
        this.pageObjectManager = testContext.getPageObjectManager();
    }
    @Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("User is on login page")
    public void User_is_on_login_page(){
        String URL = ConfigReader.get("app.url");
        driver.get(URL);
    }

    @When("^user enters username (.*) and password (.*)$")
    public void user_enter_credentials(String username, String Password){
        pageObjectManager.getLoginPageActions().enterUsername(username);
        pageObjectManager.getLoginPageActions().enterPassword(Password);
    }

    @And("clicks on login button")
    public void clicks_on_login_button(){
        pageObjectManager.getLoginPageActions().clickLogin();
    }
    @Then("user should navigated to home page")
    public void user_should_navigated_to_home_page() throws InterruptedException, IOException{
        boolean isLoaded = pageObjectManager.getHomePageActions().isHomePageLoaded();
        TestUtil.captureScreenshot(driver, "Navigate to home");
        Assert.assertTrue(isLoaded,"Home page is not opened");
    }
    @Then("user should get error message")
    public void user_should_get_error_message() {
        boolean isErrorMessageVisible= pageObjectManager.getLoginPageActions().isErrorMessageVisible();
        if(isErrorMessageVisible){
            System.out.println("error message is visible");
        } else{
            System.out.println("No error message is displayed");
        }
    }

    @Then("user should see {string} validation messages")
public void user_should_see_validation_messages(String req) {
    pageObjectManager.getLoginPageActions().isUsernameRequiredMessageVisible(req);
    pageObjectManager.getLoginPageActions().isPasswordRequiredMessageVisible(req);
    
}

    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        // String Username= ConfigReader.get("username");
        // String Password=ConfigReader.get("password");
        String scenarioName = scenario.getName().trim();
        String Username = ExcelReader.getData(scenarioName, "username");
        String Password = ExcelReader.getData(scenarioName, "password");
        pageObjectManager.getLoginPageActions().enterUsername(Username);
        pageObjectManager.getLoginPageActions().enterPassword(Password);
    }
    
}
