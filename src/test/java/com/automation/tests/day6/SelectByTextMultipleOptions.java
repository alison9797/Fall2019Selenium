package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        BrowserUtilities.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(3);
        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);// if it true. you can select more than one option

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        //let's get all selected options
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();


        for (WebElement selectedLanguage :selectedLanguages){
            System.out.println(selectedLanguage.getText());
        }
        BrowserUtilities.wait(3);

        languagesSelect.deselectByVisibleText("Java");
        BrowserUtilities.wait(3);
        languagesSelect.deselectAll();


        BrowserUtilities.wait(3);
        driver.quit();
    }
}
