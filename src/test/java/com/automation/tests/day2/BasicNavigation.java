package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.rmi.Remote;

public class BasicNavigation {

    public static void main(String[] args) throws Exception {
        //to start Selenium script we need
        //setup webdriver(browser) and create webdriver object

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //in Selenium everything starts from WebDriver interface
//ChromeDriver extends RemoteWebDriver -- > implements WebDriver


        driver.get("http://google.com"); //to open website

        Thread.sleep(3000); // for demo , wait three seconds
        //you can also see it as a tab
String title = driver.getTitle(); //returns <title> Some <title>
        String expectedTitle = "Google";
        //and print it
        System.out.println("Title is " + title);

        if (expectedTitle.equals(title)){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
        driver.close(); //to close browser. must be at the end!!!!
        //browser can not close it self


    }
}
