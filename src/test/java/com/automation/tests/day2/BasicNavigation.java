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
        String expectedTitle = "Google";//we provide it
        driver.manage().window().maximize();// to maximize browser
        //driver.manage().window().fullscreen();
        //and print it
        System.out.println("Title is " + title);

        if (expectedTitle.equals(title)){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }

        //go to another website within the same window
        driver.navigate().to("http://amazon.com");

        if (driver.getTitle().toLowerCase().contains("amazon")){

            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
        //come back to Google
        driver.navigate().back();
        verifyEquals(driver.getTitle() , "Google");


        driver.close(); //to close browser. must be at the end!!!!
        //browser can not close it self


    }
// method  verifyEquals is static because main method is static
    public static void verifyEquals(String arg1, String arg2){
        if (arg1.equals(arg2)){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
    }
}
