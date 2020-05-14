package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.utilities.ExcelUtil;
import com.automation.tests.vytrack.AbstractTestBase;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestsWithExcel extends AbstractTestBase {

    static int row ;

    @Test(dataProvider = "credentialsFromExcel")
    public void loginTestWithExcel2(String execute , String username , String password ,  String firstName, String lastName , String result){
        //determine excel file name
        String path = "VytrackTestUsers.xlsx";
        //spreadsheet name
        String spreadsheet = "QA3-short";
        //create object of excel utility class so we can write into the file
        ExcelUtil excelUtil = new ExcelUtil(path, spreadsheet);//we need to use this in the this method


        test = report.createTest("Login test for username: " + username);
        //if value of first column is y , test will executed
        if (execute.equals("y")){
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            test.info("Login as: " + username);
            test.info(String.format("First name: &s , Last name: %s , Username: %s ", firstName , lastName, username));
            test.pass("Successfully logged in as" + username);
            //write into excel file that test passed
            excelUtil.setCellData("PASSED", "result", row++);

        } else if ((execute.equals("n"))){
            test.skip("Test was skipped for user : " + username);
            //rite into excel file that test was skipped , because first column has velue 'n"
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
