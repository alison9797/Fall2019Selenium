package com.automation.tests.day7;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {
   public static  String passwordLocator = "//label[text()='Password']/following-sibling::input";
   public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    public static String loginBtnLocator = "//button[contains(text(), 'Login')]";

    public static void main(String[] args) {
////*[@id="login"]/div[1]/div/input
        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtilities.wait(3);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(loginBtnLocator)).click();


        BrowserUtilities.wait(3);
        driver.quit();
    }
}
