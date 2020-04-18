package com.automation.tests.day11;


import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {

    private WebDriver driver;


    @BeforeMethod
    public void setup(){

       driver = DriverFactory.createDriver("chrome");
       driver.get("http://practice.cybertekschool.com/");
       driver.manage().window().maximize();
        BrowserUtilities.wait(3);

    }

    @Test
    public void verifyTitle(){
        String expected = "Practice";
        //we create javascriptexecuter object by casting webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //executeScript - this method executes javascript code
        //we provide js as a string
        //"return document.title" <--- javascript code
        //document - represents HTML page
        //.toString() - to avoid additional casting from Object to String
       String actual = (String) js.executeScript("return document.title");

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void clickTest(){
     WebElement link =  driver.findElement(By.linkText("Multiple Buttons"));
     //diable this click action , to perform it with javascriptexecutor
    // link.click();

     JavascriptExecutor js = (JavascriptExecutor) driver;
     //after double quotes "" you can list webelements that will be
        //as part of your javascript code
        //it's varargs, so you can list 0+
        //arguments - listed after comma(,)
        //use index to specific webelemnt
        //WebElement arguments = {element, link, links2};
     js.executeScript("arguments[0].click()",link);

     WebElement button6 = driver.findElement(By.id("disappearing_button"));

        js.executeScript("arguments[0].click()",button6);
        BrowserUtilities.wait(3);

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"Now it's gone!");


    }

@Test
    public void inputTest(){
     driver.findElement(By.linkText("Form Authentication")).click();
     BrowserUtilities.wait(3);
    WebElement username = driver.findElement(By.name("username"));
    WebElement password = driver.findElement(By.name("password"));
    WebElement loginButton = driver.findElement(By.id("wooden_spoon"));


    JavascriptExecutor js = (JavascriptExecutor) driver;
    //to get text from input box - read attribute "value"
    //to enter text - set attribute "value"
//setAttribute('value', 'text') - enter some text
    js.executeScript("arguments[0].setAttribute('value', 'tomsmith')", username);
    js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
    js.executeScript("arguments[0].click()", loginButton);

    BrowserUtilities.wait(4);
    String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();
    String expected = "Welcome to the Secure Area. When you are done click logout below." ;
    //String actual = driver.findElement(By.tagName("h4")).getText();

    Assert.assertEquals(subheader, expected);
    }


    @Test
    public void scrollToElement(){
        WebElement link = driver.findElement(By.linkText("Cybertek School"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", link);
    }

    @Test
    public void scrollTest(){
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i < 15; i++) {
            js.executeScript("window.scrollBy(0, 1000)");
            BrowserUtilities.wait(1);
        }





    }

    @AfterMethod
    public void teardown(){
        BrowserUtilities.wait(3);
        driver.quit();
    }
}
