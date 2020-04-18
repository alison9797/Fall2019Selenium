package com.automation.tests.day11;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {

    private WebDriver driver;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it to true to make it work
        chromeOptions.setHeadless(true);//to run browser without GUI invisible browser

      driver = new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        BrowserUtilities.wait(3);

    }

    @AfterMethod
    public void teardown(){
        BrowserUtilities.wait(3);
        driver.quit();
    }
    @Test
    public void getColumnsNames(){

       List<String> expected = Arrays.asList("Last Name" , "First Name" , "Email" , "Due" ,"Web Site","Action" );
        List <WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement columnName: columnNames) {
            System.out.println(columnName.getText());

        }
        Assert.assertEquals(BrowserUtilities.getTextFromWebElements(columnNames), expected);
    }

    @Test
    public void verifyRowCount(){
        // //tbody//tr -> to get all roes table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get the size of this collective, it automatically equals to number of elements
        Assert.assertEquals(rows.size(), 4);
    }
    //to get specific column, skip rpw index , and just provide td index
    @Test
    public void getSpecificColumn(){

        //td[5] -column with links
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println( BrowserUtilities.getTextFromWebElements(links));

    }

////table[1]//td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']
   //go to tables
    //delete record with jsmith email
    //verify that number of row is equals to 3
    //verify that jsmith gmail doesn't exists any more in the table
@Test
    public void deleteRowTest(){
        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
         driver.findElement(By.xpath(xpath)).click();
         BrowserUtilities.wait(3);
         //get count of rows
         int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
         Assert.assertEquals(rowCount, 3);

         Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());

    }


}
