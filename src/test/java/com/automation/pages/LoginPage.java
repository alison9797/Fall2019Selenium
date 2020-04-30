package com.automation.pages;

//make this Driver comes from utilities
import com.automation.tests.utilities.ConfigurationReader;
import com.automation.tests.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //these two are instant variables
    @FindBy(id="prependedInput")
    public WebElement username;


    @FindBy(id = "prependedInput2")
    public WebElement password;


    @FindBy(id = "_submit")
    public WebElement login;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;

    //THIS IS CONSTRUCTOR
    public LoginPage(){
        //this method helps us to able it
        //to connect out webdriver, page class and PageFactory to find elements
        //PageFactory - used to use @FindBy annotations
        //PageFactory - helps us to find elements easier

        //this line will be always the same
        PageFactory.initElements(Driver.getDriver(), this);

    }

    /***
     * Method to login , version #1
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue , String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
    }

    /***
     * Method to login
     * Credentials will be retrieved from configuration.properties file
     */
    public  void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
    }
    }



