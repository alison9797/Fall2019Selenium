package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2);
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        driver.findElement(By.id("wooden_spoon")).click();


        Thread.sleep(2);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();

        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //lets click on Logout button. It looks like a button , but it's actually a link
        //every element with <a> tag is a link
        //if you have  a couple spaces in the text, just use partialLinkText instead of linkText
        //linkText - equals()
        //partialLinkText - contains()
        //to be safe remove all spaces , and use partialLinkText();

        WebElement logout = driver.findElement(By.partialLinkText("Logout"));
        String href = logout.getAttribute("href");
        String className = logout.getAttribute("class");

        System.out.println(className);
        System.out.println(href);

        logout.click();
        Thread.sleep(2);

        //let's enter invalid credentials
        //NEGATIVE TEST:
        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");
        driver.findElement(By.id("wooden_spoon")).click();


        Thread.sleep(2);

        WebElement errorMessage = driver.findElement(By.id("flash-messages"));
        System.out.println(errorMessage.getText());
        Thread.sleep(2);



        driver.quit();
    }
}
