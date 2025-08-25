package com.tech.subash.java8.collectors;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Boxed {
    public static void main(String[] args) {


        IntStream intStream = IntStream.of(1, 2, 3);
        Stream<Integer> boxedStream = intStream.boxed();

        List<Integer> list = IntStream.range(1, 5) // 1, 2, 3, 4
                .boxed().collect(Collectors.toList());
        System.out.println(list);

        List<Integer> evens = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0).boxed()
                .collect(Collectors.toList());
        System.out.println(evens);
       // Output: [2, 4, 6, 8, 10]

        List<String> words = List.of("Java", "Stream", "API");

        List<Integer> wordLengths = words.stream()
                .mapToInt(String::length)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(wordLengths);


    }
}
