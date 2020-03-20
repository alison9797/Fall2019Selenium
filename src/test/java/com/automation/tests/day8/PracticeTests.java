package com.automation.tests.day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class PracticeTests {
    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
        WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.get(" http://practice.cybertekschool.com/");
       driver.manage().window().maximize();


    }
    public void teardown(){

    }



}
