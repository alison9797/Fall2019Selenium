package com.automation.tests.day10;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup(){
        //driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

    }

    @AfterMethod

    public void teardown(){
        BrowserUtilities.wait(3);
        driver.quit();
    }

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        BrowserUtilities.wait(3);

        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll down 250 pixels
        // x  ,   y <--- coordinates
        // driver.executeScript("window.scrollBy(0, 250)");

        // x  ,   y <--- offset
        for (int i = 0; i < 10; i++) {
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtilities.wait(1);
        }

        BrowserUtilities.wait(3);
    }

    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtilities.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        //scrollIntoView - javascript method
        //arguments[0] - means 1st webelement after comma
        driver.executeScript("arguments[0].scrollIntoView(true)", link);

    }
}
