package com.automation.tests.day11;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }
    public void verifyTitle(){
        String expected = "Practice";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //executeScript - this method executes javascript code
        //we provide js code as a String
        //returm document.title = javascritpt code
        //document - represents HTML
        //.toString() - to avoid additional casting from Object to String
       String actual = (String) js.executeScript("return document.title");
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void clickTest(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //after "" you can list webelements that will be used
        //as part of your javascript code
        //it's varargs, so you can list 0+
        //arguments - listed after,
        //use index to get specific webelement
        //WebElement arguments = {element, link, link2};
        //from left - to right
        js.executeScript("arguments[0].click()", link);
        WebElement button6 = driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()", button6);
        BrowserUtilities.wait(2);
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "Now it's gone!");


    }
    @Test
    public void textInputTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtilities.wait(3);
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbtn = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //to get text from input box = read attribute value
        //to enter text  - set attribute value

        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
        js.executeScript("arguments[0].click()", loginbtn);

    }

    @AfterMethod
    public void teardown(){
        BrowserUtilities.wait(2);
        driver.quit();
    }
}
