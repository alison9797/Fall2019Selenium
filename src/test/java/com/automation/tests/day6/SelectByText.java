package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        BrowserUtilities.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(3);
        //create webelement object for drop-down first
        WebElement simpleDropdown = driver.findElement(By.id("dropdown"));
        //provide webelement object into constructor
        Select selectSimpleDropdown = new Select(simpleDropdown);
        //select by visible text
        selectSimpleDropdown.selectByVisibleText("Option 2");
        BrowserUtilities.wait(3);
        //and select option 1
        selectSimpleDropdown.selectByVisibleText("Option 1");
        BrowserUtilities.wait(3);
        //select you DOB
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));



        selectYear.selectByVisibleText("1997");
        selectMonth.selectByVisibleText("July");
        selectDay.selectByVisibleText("27");

BrowserUtilities.wait(3);
        //select all months by one

//.getOptions(); -- returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement month : months){
            //get the month name and select based on that
            selectMonth.selectByVisibleText(month.getText());
            BrowserUtilities.wait(1);
        }

        BrowserUtilities.wait(5);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("District Of Columbia");

        //option that is currently selected
        //getFirstSelectedOption() --- returns a WebElement, that's why we need to call getText()
        //getText() ewtrieves visible text from the webelement

        String selected = stateSelect.getFirstSelectedOption().getText();

        if (selected.equals("District Of Columbia")){
            System.out.println("TEST PASSED");
        } else{
            System.out.println("TEST FAILED ");
        }


        List<WebElement> states = stateSelect.getOptions();
        for (WebElement stateOption : states ){
            System.out.println(stateOption.getText());
        }
             {

        }

        BrowserUtilities.wait(3);
        driver.quit();
    }
}
