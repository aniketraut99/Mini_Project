package com.aniket.Pages.Actions;

import org.bouncycastle.jcajce.provider.symmetric.util.PBE.Util;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aniket.Utils.TestUtil;

import junit.framework.Test;

public class LoginPageActions {
    private WebDriver driver;

    public LoginPageActions(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameField;
    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[text()=' Login ']")
    private WebElement loginButton;
    @FindBy(xpath = "//p[text()='Invalid credentials']")
    private WebElement error_message;
    @FindBy(xpath = "//input[@name=\"username\"]/parent::div/following-sibling::span")
    private WebElement reuiredMassage_Username;
    @FindBy(xpath = "//input[@name=\"password\"]/parent::div/following-sibling::span")
    private WebElement reuiredMassage_Password;
    @FindBy(xpath = "//*[text()='Required']")
    private WebElement reuiredMassage;
    @FindBy(xpath="//label[text()='Username']/parent::div/following-sibling::span")
    private WebElement usernameRequired;
    @FindBy(xpath = "//label[text()='Password']/parent::div/following-sibling::span")
    private WebElement passwordRequired;
    @FindBy (xpath = "//h5[text()='Login']")
    private WebElement LoginHeading;

    public void enterUsername(String username){
        TestUtil.waitForVisibility(driver, usernameField,5);
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password){
        TestUtil.waitForVisibility(driver, passwordField,5);
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickLogin(){
        TestUtil.waitForVisibility(driver, loginButton, 5);
        loginButton.click();
    }
    public void loginToApp(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    public WebElement userNameLocator(){
        return usernameField;
    }
    public boolean isErrorMessageVisible(){
        try {
            TestUtil.waitForVisibility(driver, error_message, 10);
            return true;
        } catch (Exception e) {
            System.out.println("No error message is visible");
            return false;
        }
    }
    public String reuired(){
        return reuiredMassage.getText();
    }

    public boolean userName_reqireddMassage(){
        try{
        TestUtil.waitForVisibility(driver, reuiredMassage_Username, 10);
        return true;
    } catch (Exception e){
        System.out.println("Username is there  ");
        return false;
    }
    }
    public boolean password_reqireddMassage(){
        try{
        TestUtil.waitForVisibility(driver, reuiredMassage_Password, 10);
        return true;
    } catch (Exception e){
        System.out.println("password is there  ");
        return false;
    }
    }
    public void isUsernameRequiredMessageVisible(String expectedError){
        
        try {
            TestUtil.waitForVisibility(driver, usernameRequired, 5);
            Assert.assertEquals(usernameRequired.getText(),expectedError);
        } catch (Exception e) {
            Assert.fail("No username required message");
        }
    }
    public void isPasswordRequiredMessageVisible(String expectedError){
        try {
            TestUtil.waitForVisibility(driver, passwordRequired, 5);
            Assert.assertEquals("Required message for password is not visible",passwordRequired.getText(),expectedError);
        } catch (Exception e) {
            Assert.fail("No password fail meassage");
        }
    }
    public boolean isLoginPageLoaded() {
        try {
            TestUtil.waitForVisibility(driver, LoginHeading, 5);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
    
}
