package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        BrowserUtilities.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(3);

        Select

        BrowserUtilities.wait(3);
        driver.quit();
    }
}
