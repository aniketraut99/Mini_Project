package com.aniket.Manager;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.openqa.selenium.WebDriver;

import com.aniket.Pages.Actions.HomePageActions;
import com.aniket.Pages.Actions.LoginPageActions;
import com.aniket.Utils.TestUtil;

public class PageObjectManager {
    private WebDriver driver;
    private LoginPageActions loginPageActions;
    private TestUtil testUtil;
    private HomePageActions homePageActions;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public LoginPageActions getLoginPageActions(){
        if(loginPageActions==null){
            loginPageActions = new LoginPageActions(driver);
        }
        return loginPageActions;
    }
    public TestUtil getTestUtil(){
        if(testUtil==null){
            testUtil = new TestUtil(driver);
        }
        return testUtil;
    }
    public HomePageActions getHomePageActions(){
        if(homePageActions==null){
            homePageActions = new HomePageActions(driver);
        }
        return homePageActions;
    }
    
}
