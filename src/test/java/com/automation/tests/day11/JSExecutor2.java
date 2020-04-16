package com.automation.tests.day11;


import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {

    private WebDriver driver;


    @BeforeMethod
    public void setup(){

       driver = DriverFactory.createDriver("chrome");
       driver.get("http://practice.cybertekschool.com/");
       driver.manage().window().maximize();
        BrowserUtilities.wait(3);

    }

    @Test
    public void verifyTitle(){
        String expected = "Practice";
        //we create javascriptexecuter object by casting webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //executeScript - this method executes javascript code
        //we provide js as a string
        //"return document.title" <--- javascript code
        //document - represents HTML page
        //.toString() - to avoid additional casting from Object to String
       String actual = (String) js.executeScript("return document.title");

        Assert.assertEquals(actual,expected);

    }



    @AfterMethod
    public void teardown(){
        BrowserUtilities.wait(3);
        driver.quit();
    }
}
