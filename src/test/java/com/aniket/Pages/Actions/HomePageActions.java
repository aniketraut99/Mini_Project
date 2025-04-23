package com.aniket.Pages.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aniket.Utils.TestUtil;

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

}
