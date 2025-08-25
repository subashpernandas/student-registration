package com.tech.subash.java8;

public class StringIntern {
    public static void main(String[] args) {
        // It puts the string in the string pool
        String test = "test";
        String tester = "test";
        if(test.equals(tester)){
            System.out.println("TRUE");
        } if(test == tester){
            System.out.println("TRUE");
        }

        String newTest = new String("test");
        String newTester = new String("test");
        if(newTest.equals(newTester)){
            System.out.println("TRUE 1");
        } if(newTest == newTester){
            System.out.println("TRUE 1");
        }

        if(newTest.intern().equals(newTester)){
            System.out.println("TRUE 2");
        }

        if(newTest.intern() == newTester.intern()){
            System.out.println("TRUE 3");
        }
    }
}
