package com.automation.tests.practice;

import com.automation.tests.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;

    //p tag name of success message
    //one locator for all inputs://label[text()='Label name']/..//input
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");

    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By nameBy = By.name("job_title");

    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javaScriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");

    private By signUpBy= By.id("wooden_spoon");

    @Test
    public void test1() {
        driver.findElement(firstNameBy).sendKeys("Alisa");
        driver.findElement(lastNameBy).sendKeys("Ivanov");
        driver.findElement(usernameBy).sendKeys("testuser");
        driver.findElement(emailBy).sendKeys("test@email.com");
        driver.findElement(passwordBy).sendKeys("123567890");
        driver.findElement(phoneBy).sendKeys("098-765-4321");

        driver.findElement(femaleBy).click();
        driver.findElement(dateOfBirthBy).sendKeys("01/01/2000");


        Select departmentSelect = new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        Select jobTitleSelect = new Select(driver.findElement(nameBy));
        jobTitleSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();

        driver.findElement(signUpBy).click();
        BrowserUtilities.wait(5);


        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void verifyFirstNameLengthTest(){
        driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtilities.wait(3);

        WebElement warningMessage =  driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
        Assert.assertTrue(warningMessage.isDisplayed());

    }

    @Test
    public  void verifyAlphabeticLettersOnlyTest(){
        driver.findElement(firstNameBy).sendKeys("123");
        BrowserUtilities.wait(3);

        WebElement warningMessage = driver.findElement(By.xpath("//small[text()='first name can only consist of alphabetical letters']"));
        Assert.assertTrue(warningMessage.isDisplayed());

    }

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
