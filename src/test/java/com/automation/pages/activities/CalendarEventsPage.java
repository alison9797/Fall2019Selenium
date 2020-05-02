package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.tests.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(css = "[title='Create Calendar event']")
private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private WebElement startTime;


    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private WebElement endTime;

    public String getStartTime(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }



    public String getEndTime(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }


    //whe we put current user element under base page class and owner element under create calendar event page class?
    //"current owner" element belongs to top menu
    //Top menu (or navigation menu )doesn't belong to particular page.
    //Since top menu elements are shared, we can store them in the base page class

    public String getOwnerName(){
        BrowserUtilities.waitForPageToLoad(15);
        //we wait for element to be present in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalendarEvent(){

        BrowserUtilities.waitForPageToLoad(20);
        //this wait coming from AbstractPageBase
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();

    }


    public String getStartDate(){
        BrowserUtilities.waitForPageToLoad(10);
       wait.until(ExpectedConditions.visibilityOf(startDate));
        BrowserUtilities.scrollTo(startDate);
        return startDate.getAttribute("value");
    }

}
// time left 1 hour an 30 minutes