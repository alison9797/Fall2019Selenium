package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.rmi.Remote;

public class BasicNavigation {

    public static void main(String[] args) {
        //to start Selenium script we need
        //setup webdriver(browser) and create webdriver object
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //in Selenium everything starts from WebDriver interface

        driver.get("http://google.com"); //to open website


    }
}
