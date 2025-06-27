package com.aniket.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathUtils {
    WebDriver driver;
    public XpathUtils(WebDriver driver){
        this.driver = driver;
    }
    public static WebElement getElementByText(WebDriver driver,String tag, String text){
        String xpath="//"+tag+"[text()='"+text+"']";
        return driver.findElement(By.xpath(xpath));
    }
}
