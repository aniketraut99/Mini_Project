package com.aniket.stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aniket.Manager.PageObjectManager;
import com.aniket.Pages.Actions.HomePageActions;
import com.aniket.TestContext.TestContext;
import com.aniket.Utils.ExcelReader;
import com.aniket.Utils.TestUtil;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {
    private WebDriver driver;
    private PageObjectManager pageObjectManager;
    private TestContext testContext;

    public HomePageSteps(TestContext testContext) {
        this.driver = testContext.getDriver();
        this.pageObjectManager = testContext.getPageObjectManager();
        this.testContext=testContext;
    }
    @When("User navigates to PIM Page")
    public void user_navigates_to_pim_page() {
        pageObjectManager.getHomePageActions().clickPIM();
    }
    @When("User clicks on user dropdown")
    public void user_clicks_on_user_dropdown() {
        pageObjectManager.getHomePageActions().clickUserDropdown();
    }

    @When("clicks on Add Employee")
    public void clicks_on_Add_Employee() {
        pageObjectManager.getHomePageActions().clickAddEmployee();
    }

    @When("enters first name and last name")
    public void enters_first_name_and_last_name() {
        String scenarioName = testContext.getScenario().getName().trim();
        String firstName = ExcelReader.getData(scenarioName, "First name");
        String LastName = ExcelReader.getData(scenarioName, "Last name");
        pageObjectManager.getHomePageActions().addFirstName(firstName);
        pageObjectManager.getHomePageActions().addLastName(LastName);
    }

    @When("clicks Save")
    public void clicks_Save() {
        pageObjectManager.getHomePageActions().clickAdd();
    }

    @Then("employee should be added and Personal Details page should be displayed")
    public void employee_should_be_added_and_Personal_Details_page_should_be_displayed() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        pageObjectManager.getHomePageActions().VerifyToastMessage();
        boolean personalPage =  pageObjectManager.getHomePageActions().isPersonalPageDisplay();
        Assert.assertTrue(personalPage, "Personal Page is not displayed");

    }

    
}
