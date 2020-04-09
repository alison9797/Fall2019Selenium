package com.automation.tests.day8;


import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    //runs only once in the class before @BeforeMethod and @Test
    //regardless on number of tests. it runs only once
    @BeforeClass
    public void beforeClass(){
        //something that should be done only once in the class before all tests
        System.out.println("BEFORE CLASS");

    }

    @AfterClass
    //something that should be done only once in the class after all tests
    public void afterClass(){
        System.out.println("AFTER CLASS");
    }

    //runs before every test automatically
    //works as precondition or set up
    @BeforeMethod
    public void setup(){
        System.out.println("Before Method");
    }


    //runs automatically after every test
    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");

    }

    @Test(description = "Verify if method can reverse a string")
    public void test1(){
        System.out.println("test 1");
        String actual = "apple";
        String expected = "apple";
        Assert.assertEquals(actual,expected);
    }


    @Test
    public void test2(){
        System.out.println("test 2");
        int num1 =5;
        int num2 = 10;
        //it calls hard assertion
        //if assertion fails it stops yje execution(due to exception)
        Assert.assertTrue(num1 < num2);
    }

}
