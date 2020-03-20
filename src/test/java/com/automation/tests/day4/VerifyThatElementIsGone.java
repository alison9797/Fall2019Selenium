package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {
    //INTERVIEW QUESTION :
    //HOW TO CHECK IF ELEMENT DOESN'T EXIST ANYMORE IN THE DOM (HTML DOCUMENT IN THE BROWSER)?
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2);

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2);

        //it's a collection
        //they can be empty or they can have something in it, or it can be full
        if (driver.findElements(By.id("disappearing_button")).size() == 0){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        Thread.sleep(2);
//to find all buttons
        //make sure that you use findElements <==== ending is important
        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        for (WebElement button : buttons) {
            //click on every button
            button.click();
            Thread.sleep(2);

        }
        driver.quit();
    }

}
