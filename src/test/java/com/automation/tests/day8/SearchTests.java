package com.automation.tests.day8;

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
import org.testng.annotations.Test;

import java.util.List;


public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        BrowserUtilities.wait(3);
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtilities.wait(5);

        //since every search item has a tagname <h3>
        //it is easier way to collect all of them
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));

        for (WebElement searchItem : searchItems ) {
            String var = searchItem.getText();

               //if there is text -> print it 
            if (!var.isEmpty()){
                System.out.println(var);
                
                        //verify that every search result contains "java" word
                //if some of the search results doesn't contain java word
                //it will fail the test
                Assert.assertTrue(var.toLowerCase().contains("java"));
                System.out.println(var.toLowerCase());
                System.out.println();
                
            }

        }

    }
                            /* #############TASK############################
                          Given user is on the amazon.com
                          When user enters "java" as a search item
                          Then user clicks on the search button
                          And user clicks on the first search item
                          And user verifies that title of the search item contains "java"
                           */

    @Test(description = "Search for java book on amazon")
    public void amazonSearchTest(){

        driver.get("http://amazon.com");
        BrowserUtilities.wait(5);

        driver.findElement(By.id("twotabsearchtextbox")) .sendKeys("Java", Keys.ENTER);
        BrowserUtilities.wait(5);

        List<WebElement> searchItems = driver.findElements(By.tagName("h2"));
       //click on the first item
        searchItems.get(0).click();
        BrowserUtilities.wait(5);

        WebElement productTitle = driver.findElement(By.id("productTitle"))  ;
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);
        Assert.assertTrue(productTitleString.contains("Java"));





    }


    @BeforeMethod
    public void setup(){
    //setup webdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        //close and destroy webdriver object
        driver.quit();

    }

}
