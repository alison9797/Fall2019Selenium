package com.automation.tests.day13;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverTest {


    @Test
    public void googleTest(){

        //Driver.getDriver() ---> returns driver
        Driver.getDriver().get("http://google.com");
        BrowserUtilities.wait(2);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Google");
        //coming from Driver class
        Driver.closeDriver();

    }
}
