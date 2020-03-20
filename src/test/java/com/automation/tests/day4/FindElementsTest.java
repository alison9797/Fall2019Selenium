package com.automation.tests.day4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");

        Thread.sleep(3);
        //how to collect all links from the page?
       List< WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links ) {

            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println();
        }

        for (int i = 1; i < links.size(); i++) {
            /*
            THE SHORTEST WAY:
            driver.findElement(By.tagName("a")).get(i).click();
            driver.navigate().back();
             */
            links.get(i).click();
            Thread.sleep(2);

            driver.navigate().back();
            //Thread.sleep(2);
            //refresh list
           links = driver.findElements(By.tagName("a"));

        }

        driver.quit();

    }
}
