package com.automation.tests.vytrack.activities;

import com.automation.tests.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(), 'Activities')]");
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtilities.wait(3);
        //before creating Actions class, make sure to create
        // webdriver objectfirst
        Actions actions = new Actions(driver);

        driver.findElement(usernameBy).sendKeys("storemanager85");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtilities.wait(3);

        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtilities.wait(2);
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtilities.wait(5);
    }
/*
Scenario : Verify for store manager

Login as a store manager
Go to Activities -> Calls
Verify that Log Call button is displayed
 */
    @Test
    public void verifyLogButton(){
        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);

        Assert.assertTrue(logCallBtnElement.isDisplayed());

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
