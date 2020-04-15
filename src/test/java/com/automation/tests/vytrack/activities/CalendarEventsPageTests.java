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

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CalendarEventsPageTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(), 'Activities')]");
    private By calendarEventBy = By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy = By.cssSelector("#user-menu > a ");
    private By ownerBy = By.className("select2-chose");

    private By titleBy = By.cssSelector("#oro_calendar_event_form_title-uid-5e952c896ddc4");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_end-uid']");



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtilities.wait(3);
        //before creating Actions class, make sure to create
        // webdriver object first
        Actions actions = new Actions(driver);

        driver.findElement(usernameBy).sendKeys("storemanager85");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtilities.wait(3);

        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtilities.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtilities.wait(5);

    }
    @Test
    public void verifyCreateCalendarEventBtn(){
       WebElement createCalendarEventBtn = driver.findElement(calendarEventBy);
        Assert.assertTrue(createCalendarEventBtn.isDisplayed());
    }
    /*
    This is in @BeforeMethod
    Test Case: Default Options
    Login as a sales manager
    Go to Activities --> Calendar Events


    Click on Create Calendar Events
    Default owner name should be the same as current user name
    Default title should be blank
    Default start date should be current date
    Default start time should be current time
     */

    @Test(description = "Default Options")
    public void  verifyDefaultValues() {
        //click on Create Calendar Event
        driver.findElement(calendarEventBy).click();
        BrowserUtilities.wait(3);

        //Default owner name should be the same as current user name
        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();
        // defaultOwnerName.trim();
        Assert.assertEquals(currentUserName, defaultOwnerName);

        //Default title should be blank
       WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());

       // Default start date should be current date

        String expectedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");

        Assert.assertEquals(actualDate, expectedDate);


        String expectedTime = LocalTime.now(ZoneId.of("GM")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");
        Assert.assertEquals(actualTime, expectedTime);

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
