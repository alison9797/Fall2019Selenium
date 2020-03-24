package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    //to create a test case
    public static void main(String[] args) {
//if DriverFactory doesn't work use WebDriverManager
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();//<==== maximize window
        BrowserUtilities.wait(2);

        WebElement blackButton = driver.findElement(By.id("black"));
        blackButton.click();

        //if visible and eligible to click
        if (blackButton.isDisplayed() && blackButton.isEnabled()){
            System.out.println("CLICKED ON BLACK BUTTON");
            blackButton.click();
        } else{
            System.out.println("FAILED TO CLICK ON BLACK BUTTON");
        }
        //how to verify that black button clicked
        //returns true, if button clicked
        if (blackButton.isSelected()){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
        driver.quit();
    }
}
