package com.tech.subash.java8;

import java.util.stream.Stream;

public class LazyStream {
    public static void main(String[] args) {
        Stream.of("a","b").map(s -> {
            System.out.println("processing "+ s);
            return  s.toUpperCase();
        }).forEach(System.out::println);
    }
}
