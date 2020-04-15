package com.automation.tests.day10;


import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    private WebDriver driver;
    private Actions actions;


    @BeforeMethod
    public  void setup(){
        driver = DriverFactory.createDriver("chrome");
        actions = new Actions(driver);

    }


    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtilities.wait(3);
        driver.manage().window().maximize();

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        //build() - is needed when you have a couple of actions
        //always end with perform()
        //pause(1000) -> like a Thread.sleep(1000)
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();

        BrowserUtilities.wait(3);

        //hover on the first image
        //verify that name:user1 isDisplayed
        //hover over image ta make text visible

        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
//verify that webelement that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());

        //move to the second image
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());

    }
    @Test
    public void jqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        //hover on "enabled"
        //hover on "downloads"
        //click on PDF
        WebElement enabled = driver.findElement(By.id("ui-id-3"));
        WebElement downloads = driver.findElement(By.id("ui-id-4"));
        WebElement pdf = driver.findElement(By.id("ui-id-5"));

        actions.moveToElement(enabled).pause(1000).
                moveToElement(downloads).pause(1000).
                click(pdf).
                build().perform();
    }


@Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtilities.wait(3);

        //click on accept cookies
    driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
    BrowserUtilities.wait(3);


        WebElement earth = driver.findElement(By.id("droptarget"));

        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon,earth).perform();
        String expected = "You did great!";
        String actual= earth.getText();

        Assert.assertEquals(actual,expected);

    }
    @AfterMethod
    public void teardown(){
        BrowserUtilities.wait(3);
        driver.quit();
    }

}
