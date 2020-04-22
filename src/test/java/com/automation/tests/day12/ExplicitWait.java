package com.automation.tests.day12;

import com.automation.tests.utilities.DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        //driver = DriverFactory.createDriver("chrome");
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }

    @Test
    public void waitForTitle(){
        driver.get("http://google.com");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait up to 10 seconds, until title contains "Google"
        wait.until(ExpectedConditions.titleContains("Google"));


    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
