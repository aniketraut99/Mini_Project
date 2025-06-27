package com.aniket.Pages.Actions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aniket.Utils.TestUtil;
import com.aniket.Utils.XpathUtils;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class HomePageActions {
    private WebDriver driver;
    public HomePageActions(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@class='oxd-topbar-header']//*[text()='Dashboard']")
    private WebElement Dashboard;
    @FindBy(xpath = "//*[text()='Employee Distribution by Location']")
    private WebElement Employee_Distribution_by_Location;
    @FindBy(xpath="//div[@class='oxd-topbar-header-userarea']")
    private WebElement user_dropdown;
    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement Logout;
    @FindBy(xpath="//span[text()='PIM']")
    private WebElement PIM;
    @FindBy(xpath = "//a[text()='Add Employee']")
    private WebElement AddEmployee;
    @FindBy(xpath="//input[@name='firstName']")
    private WebElement firstName_editField;
    @FindBy(xpath="//input[@name='lastName']")
    private WebElement lastName_editField;
    @FindBy(xpath="//button[@type='submit']")
    private WebElement save;
    @FindBy(xpath="//p[text()='Success']")
    private WebElement SuccessfulToastMessage;
    public By successToastMessageElement = By.xpath("//p[text()='Success']");
    @FindBy(xpath = "//h6[text()='Personal Details']")
    private WebElement PersonalDetails;

    public boolean isHomePageLoaded() throws InterruptedException{
        Thread.sleep(2000);
        try {
            TestUtil.waitForVisibility(driver, Dashboard, 5);
            return true;
        } catch (Exception e) {
            System.out.println("HomePage failed to load within the timeout");
            return false;
        }
    }
    public void clickUserDropdown(){
        TestUtil.waitForVisibility(driver, user_dropdown, 5);
        user_dropdown.click();
    }
    public void clickLogoutButton(){
        TestUtil.waitForVisibility(driver, Logout, 5);
        Logout.click();
    }

    public void clickPIM(){
        TestUtil.waitForVisibility(driver, PIM, 2);
        PIM.click();
    }

    public void clickAddEmployee(){
        TestUtil.waitForVisibility(driver, AddEmployee, 2);
        AddEmployee.click();
    }
    public void addFirstName( String firstName){
        TestUtil.waitForVisibility(driver, firstName_editField, 2);
        firstName_editField.sendKeys(firstName);
    }
    public void addLastName( String lastName){
        TestUtil.waitForVisibility(driver, lastName_editField, 2);
        lastName_editField.sendKeys(lastName);
    }
    public void clickAdd(){
        TestUtil.waitForVisibility(driver, save, 2);
        save.click();
    }
    public void VerifyToastMessage(){
        String toastMessage = TestUtil.getToastMessage(driver, SuccessfulToastMessage,2);
        Assert.assertEquals(toastMessage, "Success");
    }
    public boolean isPersonalPageDisplay() throws IOException{
        try {
            TestUtil.waitForVisibility(driver, PersonalDetails, 10);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Personal Page is not displayed" + e.getMessage());
            TestUtil.captureScreenshot(driver, "isPersonalPageDisplay");
            return false;
        }
    }
    

}
