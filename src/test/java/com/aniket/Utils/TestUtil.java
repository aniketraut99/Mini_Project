package com.aniket.Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil {
    WebDriver driver;
    public TestUtil(WebDriver driver){
        this.driver=driver;
    }

    public static void captureScreenshot(WebDriver driver,String testName) throws IOException{
        TakesScreenshot tk = (TakesScreenshot) driver;
		File file = tk.getScreenshotAs(OutputType.FILE);
        String filePath=System.getProperty("user.dir") + "/screenshots/"+ testName + "_"+ System.currentTimeMillis() + ".png";
        File dest = new File(filePath);
        // Ensure the screenshots folder exists
        dest.getParentFile().mkdirs();
		FileHandler.copy(file, dest);
		System.out.println("Screenshot saved at: " + filePath);
    }
    
    public static void scrollToElement(WebDriver driver,WebElement element){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        }
        catch(Exception e){
            System.out.println("Error while scrolling to element: " + e.getMessage());
        }
    }
    public static void waitForVisibility(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForVisibility(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static String getToastMessage(WebDriver driver,WebElement toastlocator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        WebElement toastElement = wait.until(ExpectedConditions.visibilityOf(toastlocator));
        return toastElement.getText();
    }
}
