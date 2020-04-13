package com.automation.tests.vytrack.fleet;

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

public class VehiclesTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    //correct credentials for Store Manager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");
    private By pageNumberBy= By.cssSelector("input[type='number']");

@Test
public void verifyPageNumber(){
    String expected = "1";
    String actual = driver.findElement(pageNumberBy).getAttribute("value");

    Assert.assertEquals(actual, expected);


}
    @Test
     public void verifyPageSubTitle(){
        //login
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        //put more wait time here if not clicking
        BrowserUtilities.wait(3);
        //click on Fleet
        //driver.findElement(fleetBy).click();
        //Actions class is used for more advanced browser interactions
        Actions actions = new Actions(driver);
        //move to element instead of click
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        //perform() is to execute command
        //every actions should end with .perform()

        BrowserUtilities.wait(3);
        //click on Vehicles
        driver.findElement(By.linkText("Vehicles")).click();
        //put more wait time if you are getting Cars,Dashboard
        //this application is  slow
        BrowserUtilities.wait(5);
        //find subtitle element
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());

        String expected = "All Cars";
        String actual = subTitleElement.getText();

        Assert.assertEquals(actual, expected);



     }
@BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);

    driver.findElement(usernameBy).sendKeys(username);
    driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

    BrowserUtilities.wait(3);
    Actions actions = new Actions(driver);

    actions.moveToElement(driver.findElement(fleetBy)).perform();

    }

    @AfterMethod
    public void teardown(){
    driver.quit();
    }
}
