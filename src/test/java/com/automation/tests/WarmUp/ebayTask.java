package com.automation.tests.WarmUp;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ebayTask {
    public static void main(String[] args) throws Exception {
       // ebayTest();
       // amazonTest();
        wikiTest();
    }
    public static void ebayTest() throws Exception{
        /* Go to ebay
        enter search term
        click on search button
        print number of result */

        WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       //to open ebay.com
       driver.get("https://www.ebay.com");
        Thread.sleep(2);
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]);

        driver.quit();
    }
    public static void amazonTest() throws Exception {
        /* go to amazon
        Go to ebay
        enter search term
        click on search button
        verify title contains search term */

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        //enter text and click ENTER
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);
        Thread.sleep(4);
        String title = driver.getTitle();
        if (title.contains("java book")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
    }


    public static void wikiTest() throws Exception{
        /* Go to wikipedia.org
        enter search term `selenium webdriver`
        click on search button
        click on search result `Selenium (software)`
        verify url ends with `Selenium_(software)` */

        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/wiki/Main_Page");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        Thread.sleep(2);
        String url = driver.getCurrentUrl();
        if (url.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }
        driver.quit();
//https://en.wikipedia.org/w/index.php?cirrusUserTesting=control&search=selenium+webdriver&title=Special%3ASearch&go=Go&ns0=1
    }
}
