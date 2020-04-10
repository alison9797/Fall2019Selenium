package com.automation.tests.day8;

import com.automation.tests.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTests {
    private WebDriver driver;

    @Test
    public void loginTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        String actual = driver.findElement(By.tagName("h4")).getText();
       String expected = "Welcome to the Secure Area. When you are done click logout below.";
       //if assertion fails -? it will throw exception and message will be printed
        //3 parameters:( expected, actual, message in case of error)
        Assert.assertEquals(actual,expected, "Sub-header message is not matching!");
    }

    @Test
    public void forgotPassword(){
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtilities.wait(3);
        driver.findElement(By.name("email")).sendKeys("alison9797@mail.com", Keys.ENTER);
        BrowserUtilities.wait(3);

        String actual = driver.findElement(By.name("confirmation_message")).getText();
        String expected = "Your e-mail's been sent!";
        Assert.assertEquals(actual,expected, "Confirmation message is not valid!");

    }
    @Test
    public void checkBoxes(){
        driver.findElement(By.linkText("Checkboxes")).click();
        //locator for specific checkbox , xpath : //input[]
        //collect all checkboxes
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        BrowserUtilities.wait(4);

        checkBoxes.get(0).click();// to click on first check box

        Assert.assertTrue(checkBoxes.get(0).isSelected(), "Checkboxe #1 is not selected!");
        BrowserUtilities.wait(4);


    }

    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
        WebDriverManager.chromedriver().setup();
        //to ignore "your connection is not private issue
        //ChromeOptions -> use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setAcceptInsecureCerts(true);
      driver = new ChromeDriver(chromeOptions);
       driver.get(" http://practice.cybertekschool.com/");
       driver.manage().window().maximize();


    }
    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");
        driver.quit();

    }



}
