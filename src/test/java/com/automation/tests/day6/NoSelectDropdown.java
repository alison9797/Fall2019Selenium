package com.automation.tests.day6;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        BrowserUtilities.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(3);

        driver.findElement(By.id("dropdownMenuLink")).click();// to expand dropdown
        BrowserUtilities.wait(2);
        //it's looks like dropdown , but actually it is not
        //driver.findElement(By.linkText("Google")).click();//click on option

        //how to collect all links
        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement link : allLinks ) {
            System.out.println(link.getText()+ " : " + link.getAttribute("href"));

        }

        driver.findElement(By.linkText("Etsy")).click(); //click on option

        BrowserUtilities.wait(3);
        driver.quit();
    }
}
