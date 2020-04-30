package com.automation.tests.vytrack.fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.Driver;
import com.automation.tests.vytrack.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewVehiclesTests extends AbstractTestBase {


    @Test
    public void verifyTitle(){

        LoginPage loginPage = new LoginPage();
        VehiclesPage vehiclesPage = new VehiclesPage();

        loginPage.login();
        vehiclesPage.navigateTo("Fleet", "Vehicles");

        BrowserUtilities.wait(5);
        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
