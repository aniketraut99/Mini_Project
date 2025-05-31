package com.aniket.Pages.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aniket.Utils.TestUtil;

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
    

}
