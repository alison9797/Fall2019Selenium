package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        BrowserUtilities.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("DC");

        String expected = "District Of Columbia";
        String actual = stateSelect.getFirstSelectedOption().getText();

        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }



        BrowserUtilities.wait(3);
        driver.quit();
    }
}
