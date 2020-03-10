package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToNewWindow {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);
        //every window has some id , this id calls the window handle
        //based on window handle , we can switch in between windows

        String windowHandle = driver.getWindowHandle();

        System.out.println(windowHandle);
        Set< String> windowsHandles = driver.getWindowHandles();
//driver.getWindowHandles();   <--- returns id of all currently open windows
        //Set <-- doesn't allow duplicates(REQUARED TO USE)
        System.out.println(windowsHandles);

        //since we have all windows and we have an ids for them
        //we can say switch to something that is not equals to old windows
        System.out.println("BEFORE SWITCH : " + driver.getCurrentUrl());

        for (String windowId : windowsHandles ) {
            if (!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
            }

        }

        System.out.println("AFTER SWITCH : "+driver.getCurrentUrl());


driver.close();

    }

    /***
     * This method helps to switch in between windows based on page title
     * @param pageTitle
     * @param driver
     */
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String > windows = driver.getWindowHandles();
        for (String window : windows ) {

            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }

        }
    }
}
