package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtilities.wait(3);
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();//to click on first button
        BrowserUtilities.wait(3);

        String popupText = driver.switchTo().alert().getText();// will return pop up message text
        System.out.println(popupText);
        driver.switchTo().alert().accept();//to click Ok

        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        //will fail because there is a typo
        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }




        BrowserUtilities.wait(3);
        driver.quit();
    }
}
