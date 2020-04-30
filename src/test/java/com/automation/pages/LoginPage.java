package com.automation.pages;

//make this Driver comes from utilities
import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.ConfigurationReader;
import com.automation.tests.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

public class LoginPage {

    //these two are instant variables
    @FindBy(id="prependedInput")
    private WebElement username;


    @FindBy(id = "prependedInput2")
    private WebElement password;


    @FindBy(id = "_submit")
  private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

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
     * log in as a specific user
     */
    public void login(String usernameValue , String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.wait(3);
    }

    /***
     * Method to login
     * Credentials will be retrieved from configuration.properties file
     */
    public  void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtilities.wait(3);
    }
    }



