package com.tech.subash.pass.by.values;

public class PassByValueUsingPrimitive {
    public static void main(String[] args) {
        int a = 5;
        changeValue(a);
        System.out.println(a); // Output: 5

    }

    static void changeValue(int x) {
        x = 10;
    }
}
