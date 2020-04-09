package com.automation.tests.day8;


import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTestNGTests {

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
        Assert.assertTrue(num1>num2);
    }

}
