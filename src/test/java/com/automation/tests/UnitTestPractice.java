package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    public static void main(String[] args) {
        //UNIT TEST
        //to check if our method works properly
        //if assertion fails , it means out method doesn't work correctly
        //that means we need to fix it

      //  System.out.println(reverseString("apple"));
        String expected ="cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        //Assertion
        verifyEquals(expected,actual);
    }
    //in this case we don't use main method
    //ANNOTATION
    //description is not working for JUnit , only for testng
    @Test(description = "Verify if method can reverse a string")
    public void test(){
        String expected = "elppa";
        String actual = reverseString("apple");
        //it's coming from testng, junit also has a class
        //you can compare any data types here: strings, primitives, arrays, objects
        //to verify if expected result equals to actual
        Assert.assertEquals(actual,expected);
}
@Test(description = "Verify if method can reverse a string")
public void test2(){
        String expected = "rac";
        String actual = reverseString("car");
        Assert.assertEquals(actual,expected);


}

    public static boolean verifyEquals(String expected , String actual){
        if (expected.equals(actual)){
            System.out.println("Test Passed!");
            return true;
        } else {
            System.out.println("Test Failed!");
            System.out.println("expected = " + expected);
            System.out.println("actual = " + actual);
            return false;
        }
    }

    /***
     * This method stands for reversing strings.
     * @param str to reverse
     * @return reversed String
     */

    public static String reverseString(String str){
        String reversed = "";
        for (int i=str.length() -1; i>=0; i--){
            reversed+= str.charAt(i);

        }
        return reversed;
    }
}
