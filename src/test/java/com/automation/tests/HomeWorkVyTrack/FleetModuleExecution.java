package com.automation.tests.HomeWorkVyTrack;

import com.automation.tests.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FleetModuleExecution {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("user7");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");

        driver.findElement(By.id("_submit")).click();
        BrowserUtilities.wait(2);

        driver.findElement(By.linkText("Fleet")).click();
        BrowserUtilities.wait(2);
        driver.findElement(By.linkText("Vehicle Costs")).click();
        BrowserUtilities.wait(2);

        driver.quit();

    }
}
