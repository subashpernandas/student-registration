package com.tech.subash.java8;

public class JavaTricky {
    public static void main(String[] args) {
        // Integer caching applies to -128 to 127
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b); // true

        Integer x = 200;
        Integer y = 200;
        System.out.println(x == y); // false

        int i = 182327394;
        int j = 182327394;
        System.out.println(i == j); // true
    }
}
