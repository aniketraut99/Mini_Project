package com.aniket.Pages.Actions;

import org.bouncycastle.jcajce.provider.symmetric.util.PBE.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aniket.Utils.TestUtil;

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
}
