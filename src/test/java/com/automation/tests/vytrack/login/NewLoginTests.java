package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.utilities.BrowserUtilities;
import com.automation.tests.utilities.Driver;
import com.automation.tests.utilities.ExcelUtil;
import com.automation.tests.vytrack.AbstractTestBase;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {

    static int row = 1;

    @Test(groups = "smoke")
    public void verifyPageTitle(){
        //test is coming from extend test
        //we must add to every test at the beginning
        //                                  "Test name"
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        //its like system.out , but it goes to report
        test.info("Login as store manager");//log some steps
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        //is assertion passed , it will set test status in report to passed
        test.pass("Page title Dashboard was verified");

    }

//Enter wrong credentials and verify warning message
    @Test
    public void verifyWarningMessage(){
        test = report.createTest("Verify warning message");
        LoginPage loginPage = new LoginPage();
        loginPage.login("wrong", "wrong");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
        //take a screenshot
        BrowserUtilities.getScreenshot("LoginPage");
        test.pass("Warning message is displayed");
    }


    @Test(dataProvider = "credentials")
    public void loginWithDDT(String username , String password){
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
        test.info("Login as");
        BrowserUtilities.wait(2);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
        test.pass("Page title Dashboard was verified");

    }


    @DataProvider
    public Object[] [] credentials(){
        return new Object[][]{
                //we have three sets of test data
                //so test will be run 3 times
                //   username          password
                {"storemanager85",  "UserUser123"},
                {"salesmanager110", "UserUser123"},
                {"user16",          "UserUser123"}
                //can return Object[][] or Object[] or Iterator<Object[]>
                //Object[] - 1 column with a data
                //Object[][] 2+
                //two dimensional array
        };

    }

    @Test(dataProvider = "credentialsFromExcel")
    public void loginTestWithExcel(String execute , String username , String password ,  String firstName, String lastName , String result){
        test = report.createTest("Login test for username: " + username);

        if (execute.equals("y")){
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            test.info("Login as: " + username);
            test.info(String.format("First name: &s , Last name: %s , Username: %s ", firstName , lastName, username));
            test.pass("Successfully logged in as" + username);


        } else {
            test.skip("Test was skipped for user : " + username);

            //to skip some test with TestNG
            throw new SkipException("Test was skipped for user " + username);
        }

    }


    @Test(dataProvider = "credentialsFromExcel")
    public void loginTestWithExcel2(String execute , String username , String password ,  String firstName, String lastName , String result){

        String path = "VytrackTestUsers.xlsx";
        String spreadsheet = "QA3-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadsheet);//we need to use this in the this method


        test = report.createTest("Login test for username: " + username);

        if (execute.equals("y")){
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            test.info("Login as: " + username);
            test.info(String.format("First name: &s , Last name: %s , Username: %s ", firstName , lastName, username));
            test.pass("Successfully logged in as" + username);
            excelUtil.setCellData("PASSED", "result", row++);

        } else {
            test.skip("Test was skipped for user : " + username);
            excelUtil.setCellData("SKIPPED", "result", row++);

            //to skip some test with TestNG
            throw new SkipException("Test was skipped for user " + username);
        }

    }

    @DataProvider
        public Object [][] credentialsFromExcel(){
        String path = "VytrackTestUsers.xlsx";
        String spreadsheet = "QA3-short";
        ExcelUtil excelUtil = new ExcelUtil(path, spreadsheet);
        return excelUtil.getDataArray();

}

}
