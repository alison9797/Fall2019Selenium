package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.tests.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(css = "[title='Create Calendar event']")
private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    //whe we put current user element under base page class and owner element under create calendar event page class?
    //"current owner" element belongs to top menu
    //Top menu (or navigation menu )doesn't belong to particular page.
    //Since top menu elements are shared, we can store them in the base page class

    public String getOwnerName(){
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalendarEvent(){

        BrowserUtilities.waitForPageToLoad(10);
        //this wait coming from AbstractPageBase
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();




    }


}
