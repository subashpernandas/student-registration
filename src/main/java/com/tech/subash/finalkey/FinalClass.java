package com.tech.subash.finalkey;

import java.util.ArrayList;
import java.util.List;

public class FinalClass {

    final int value;  // its already assigned we can't re-assign via constructor
    {
        value = 0;
    }

    FinalClass(int value) {  // must be assigned in the constructor
        // this.value = value;
    }

    public int calculate(final int x) {
        // return x++; // compile time error
        return value;
    }

    public static void main(String[] args) {
        final List<String> list = new ArrayList<>();
        list.add("Hello");  // ✅ allowed
        list.add("test");
        list.remove("test");
        System.out.println(list);
        // list = new ArrayList<>(); // ❌ Compile-time error

        final StringBuilder sb = new StringBuilder("Hi");
        sb.append(" there"); // ✅ Allowed
        // sb = new StringBuilder(); // ❌ Error
    }
}
