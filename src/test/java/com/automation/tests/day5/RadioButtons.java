package com.automation.tests.day5;

import com.automation.tests.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) throws Exception {
        //SET UP DRIVER:
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        //Thread.sleep(2000);
        //above and under the same thing !!!!
        BrowserUtilities.wait(2);
        //<input type="radio"> ====> every  single radio button has this
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement radioButton : radioButtons) {
//<input type="radio" id="red" name = "color">
            String id = radioButton.getAttribute("id");
            //if button is eligible to click
            //returns true if button already clicked
            //id is always unique
            //in this case radio buttons call the same name as id

            boolean isSelected = radioButton.isSelected();
            System.out.println(id + " is selected ? " + isSelected);


            //isEnabled() to check if button can be clicked
            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("Clicked on : " + id);
                BrowserUtilities.wait(1);
            } else {
                System.out.println("Button is disabled, not clicked : " + id);
            }
            System.out.println();
        }
            driver.quit();
        }
    }

