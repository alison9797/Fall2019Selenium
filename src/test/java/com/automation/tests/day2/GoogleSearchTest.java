package com.automation.tests.day2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        Thread.sleep(2);
        //it will look for some element with the name "q"
        //name is one of the Selenium locators
        //we use locators to find webElements
        //to choose locator, just use By.locator
        WebElement search = driver.findElement(By.name("q"));
        //once we found an element , how to enter text
        //to enter text use sendKeys() method
        //how to press enter after we entering the text
        //use Key.ENTER - perform keyboard click
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(2);
        //Thread.sleep() - is used to pause java program
        //if you see <a> element it's called link
        ///visible text of this link , can be used by selenium to find this element
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();//to click on the element
        Thread.sleep(4);

        driver.quit();
    }
}