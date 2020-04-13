package com.automation.tests.vytrack.login;

import com.automation.tests.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//static import of all assertions
//allows you to use static method without specifying class name
import static org.testng.Assert.*;

import org.testng.Assert.*;
import org.testng.annotations.Test;

public class LoginPageTest {

    private WebDriver driver;
    //https is a secure version of http protocol
    //http - it's hypertext transfer protocol that every single website is using now days
    //https - data encrypted, no chance for hackers to retrieve info
    // http - data as a plain text, very easy to hack it
    private String URL = "https://qa2.vytrack.com/user/login";
    //correct credentials for Store Manager
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    //> in css selector means the same thing as / in xpath - direct child
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");
    //if we not going to use variables in other class, keep them private

    @Test(description = "verify that warning message displays when user enters invalid username")
    public void invalidUsername(){
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtilities.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual,expected);


    }
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }
    @AfterMethod
    //if driver object is alive
    public void teardown(){
        //close browser, close session
        if (driver != null) {
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }
}
