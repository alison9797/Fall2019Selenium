package com.automation.tests;

public class UnitTestPractice {

    public static void main(String[] args) {
      //  System.out.println(reverseString("apple"));
        String expected ="cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
    }



    public boolean verifyEquals(String expected , String actual){
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
