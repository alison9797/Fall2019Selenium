package com.automation.pages;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.nio.channels.AcceptPendingException;

/***
 * this class will be extended by page classes
 * Any common webelements/locators can be stored here
 * Since navigation menu doesn't  belong to particular page
 * We can not really create a dedicated page
 * elements from that menu
 */
public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();

    public AbstractPageBase(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /***
     * Method for vytrack navigation. Provide tab and module name to navigate
     *
     * @param tabName like Dashboards, Fleet or Customers
     * @param moduleNAme like Vehicles, Vehicles Odometer and Vehicle Costs
     */

    public void navigateTo(String tabName, String moduleNAme){
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(), '"+tabName+"')]";
        String moduleNameXpath = "//span[@class='title title-level-2' and text()='"+moduleNAme+"']";
        Actions actions = new Actions(driver);

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleNameXpath));

        BrowserUtilities.wait(4);

        actions.moveToElement(tabElement).pause(2000).
                click(moduleElement).build().perform();


    }
}
