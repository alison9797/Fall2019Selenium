package com.automation.tests.day12;

import com.automation.tests.utilities.DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
//create webdriver object
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait up to 10 seconds, until title contains "Google"
        wait.until(ExpectedConditions.titleIs("Google"));

        driver.navigate().to("https://www.google.com/");

        wait.until(ExpectedConditions.titleIs("Google"));

        driver.navigate().to("https://amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));


    }

    @Test
    public void waitForVisibility(){

        driver.get("http://practice.cybertekschool.com/login");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //click on start button
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));


        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submitBtn));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();

        String expected  ="Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();

        Assert.assertEquals(actual, expected);




    }


    @AfterMethod
    public void teardown(){

        driver.quit();
    }
}
