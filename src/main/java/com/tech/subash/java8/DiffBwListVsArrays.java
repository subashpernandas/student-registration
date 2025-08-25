package com.tech.subash.java8;

import java.util.*;

public class DiffBwListVsArrays {

    public static void main(String[] args) {
        // ARRAYS => NULL IS ALLOWED, STATIC ARRAY , MUTABLE
        List<String> names = Arrays.asList("subahs", "ajith","monish",null);
        names.set(0, "pernandas"); // VALID
        names.set(3, "NULL");
        System.out.println(names);

        // LIST => NULL IS NOT ALLOWED & COMPLETELY IMMUTABLE Java 9+
        List<String> list = List.of("subahs", "ajith","monish");
        //list.set(0, "pernandas"); // IN-VALID UN SUPPORTED OPERATION
        System.out.println(list);

        // UNMODIFIABLE LIST
        List<String> original = new ArrayList<>(List.of("a", "b", "c"));
        List<String> unmodifiable = Collections.unmodifiableList(original);
        original.set(0, "x"); // Affects unmodifiable list too
        System.out.println("after set " + unmodifiable);
        original.remove("x");
        System.out.println("after remove "+ unmodifiable);
        //unmodifiable.set(0, "y"); // IN-VALID UN SUPPORTED OPERATION
        //unmodifiable.add("z"); // IN-VALID UN SUPPORTED OPERATION
    }
}
