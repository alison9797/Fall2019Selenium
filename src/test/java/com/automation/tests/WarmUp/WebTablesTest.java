package com.automation.tests.WarmUp;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables#delete");


    }
    @Test
    public void test() {
//click on column nM E
        driver.findElement(By.xpath("//table[1]//span[text()='Last Name']")).click();
        BrowserUtilities.wait(2);
        //COLLECT ALL VALUES FROM THE FIRST COLUMN
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));

        for (int i=0; i<column.size() -1; i++){
            String value = column.get(i).getText();
            String nextValue = column.get(i+1).getText();
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }

    }

    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}
