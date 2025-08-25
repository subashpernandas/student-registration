package com.tech.subash.java8.iq;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class ReplaceAll {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "carol");

        UnaryOperator<String> capitalize = s -> s.substring(0, 1).toUpperCase() + s.substring(1);
        names.replaceAll(capitalize);

        System.out.println(names); // Output: [Alice, Bob, Carol]
    }
}
