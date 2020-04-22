package com.automation.tests.day11;

import com.automation.tests.utilities.BrowserUtilities;
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
        WebDriverManager.chromedriver().setup();
       // ChromeOptions chromeOptions = new ChromeOptions();
        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it to true to make it work
      //  chromeOptions.setHeadless(true);//to run browser without GUI invisible browser

    //  driver = new ChromeDriver(chromeOptions);
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
        // //tbody//tr -> to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get the size of this collection, it automatically equals to number of elements
        //expected 4 rows in the table
        Assert.assertEquals(rows.size(), 4);
    }


    //to get specific column, skip row index , and just provide td index
    @Test
    public void getSpecificColumn(){

        //td[5] -column with links
        //we are not specifying the row , to include all of them
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println( BrowserUtilities.getTextFromWebElements(links));

    }

////table[1]//td[text()='jdoe@hotmail.com']//following-sibling::td/a[text()='delete']
   //go to tables
    //delete record with jsmith@gmail.com
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


         List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));
         Assert.assertTrue(emails.isEmpty());

    }

    /**
     * Let's write a function that will return column index based on the column name
     */

    @Test
    public void getColumnIndexByName(){
        String columnName = "Email";

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[2]//th"));
      int index =0;
        for (int i = 0; i < columnNames.size(); i++) {
            String actualColumnName = columnNames.get(i).getText();
            System.out.println(String.format("Column name: %s, position %s", actualColumnName, i));

            if (columnNames.get(i).getText().equals(columnName)) {
                index = i +1;
                break; //no need to keep going

            }
        }

        Assert.assertEquals(index , 3);

    }

    @Test
    public void getSpecificCell(){

        String expected = "http://www.jdoe.com";
        int row = 3 ;
        int column = 5;
        String xpath  = "//table[1]//tbody//tr[" + row + "[//td[" + column + "]";

        WebElement cell = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(cell.getText(), expected);


    }


}
