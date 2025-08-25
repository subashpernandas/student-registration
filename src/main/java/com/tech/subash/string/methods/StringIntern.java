package com.tech.subash.string.methods;

public class StringIntern {
    public static void main(String[] args) {
        String s = "subash";
        String s1 = new String("subash");
        System.out.println(s.equals(s1));  // true
        System.out.println(s==s1);  // False
        System.out.println(s.equals(s1.intern()));  // true
        System.out.println(s.intern().equals(s1)); // true

        System.out.println(s.intern() == s1);  // False
        System.out.println(s == s1.intern() );  // True

        //intern() checks the String Pool for a string with the same content.
        //"subash" already exists in the pool (from s).Returns the reference to the pool object.

        // == checks reference equality.
        //equals() checks value equality.

        // Purpose
        // Ensures that all equal strings share the same memory in the String Pool.
        // Helps save memory and allows fast equality checks using ==
        // How it works
        // If the string already exists in the String Pool, intern() returns the reference from the pool.
        // If it doesn’t exist, it adds the string to the pool and returns that reference.
    }
}
