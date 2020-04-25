package com.automation.tests.day12;

import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentWaitTest {
    private WebDriver driver;


    @BeforeMethod
     public void setup(){
         driver = DriverFactory.createDriver("chrome");
     }



     @AfterMethod
     public void teardown(){
        driver.quit();
     }


     @Test
     public void fluentWaitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

        //If error happens it doesn't stop our script
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(10)).
                pollingEvery(Duration.ofSeconds(5)).
                //NoSuchElementException error we should put for sure
                ignoring(NoSuchElementException.class).ignoring(ElementClickInterceptedException.class);
                //other exceptions based on the error


         //anonymous - class without name
         //Function is interface, and apply is the method from this interface
         WebElement submitBtn = wait.until(new Function<WebDriver, WebElement>() {
             @Override
             public WebElement apply(WebDriver webDriver) {
                 return driver.findElement(By.xpath("//button[text()='Submit']"));
             }
         });
         driver.findElement(By.name("username")).sendKeys("tomsmith");
         driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
         submitBtn.click();
         }






     }
