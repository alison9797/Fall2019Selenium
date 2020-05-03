package com.automation.tests.vytrack;

import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.ConfigurationReader;
import com.automation.tests.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

//this class has to be extended, because it's abstract
//not using on it's own
public abstract class AbstractTestBase {
    //will be visible in the subclass. regardless on subclass location(same package or no)
    protected WebDriverWait wait;
    protected Actions actions;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;

    @BeforeTest
    public void setupTest(){
        report = new ExtentReports();
        String reportPath = System.getProperty("user.dir") + "/test-output/report.html";
        //html report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }

    @AfterTest
    public void tearDownTest(){
        //to release report
        report.flush();
    }


    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }



    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult class describes the result of a test.
        //if test failed , take a screenshot
    if (iTestResult.getEndMillis() == ITestResult.FAILURE){
  String screenshotPath =   BrowserUtilities.getScreenshot(iTestResult.getName());
    test.addScreenCaptureFromPath(screenshotPath);
    BrowserUtilities.wait(2);
    test.fail(iTestResult.getName());//attach test name that failed
    test.fail(iTestResult.getThrowable());//attach console output
}
    BrowserUtilities.wait(2);
        Driver.closeDriver();

    }

}
