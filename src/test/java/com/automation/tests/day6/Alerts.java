package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        System.out.println("TEST #1");
        //will fail because there is a typo
        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
        }
       // BrowserUtilities.wait(3);

        buttons.get(1).click();//to click on the second button
       // BrowserUtilities.wait(3);
        //to click cancel :
        driver.switchTo().alert().dismiss();//RESULT MUST BE :You clicked: Cancel

        String expected2 = "You clicked: Cancel";
        String actual2= driver.findElement(By.id("result")).getText();
        System.out.println("TEST #2");
        if (expected2.equals(actual2)){
            System.out.println(" TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("expected = " + expected2);
            System.out.println("actual = " + actual2);
        }
        BrowserUtilities.wait(3);

        buttons.get(2).click();

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Hello, World!");//to enter text
        alert.accept();//to click okay

        String actual3 = driver.findElement(By.id("result")).getText();
        String expected3 = "Hello, World!";
        System.out.println("TEST #3");
        if (actual3.endsWith(expected3)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("expected = " + expected3);
            System.out.println("actual = " + actual3);
        }
        BrowserUtilities.wait(3);

        driver.quit();
    }
}
