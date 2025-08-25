package com.tech.subash.java8.collectors;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTypes {
    public static void main(String[] args) {

        List<String> names = Stream.of("Alice", "Bob", "Charlie").toList();
        //.collect(Collectors.toList());

        Set<Integer> numbers = Stream.of(1, 2, 2, 3).collect(Collectors.toSet());

        String joined = Stream.of("Java", "is", "fun").collect(Collectors.joining(" "));

        String joined1 = String.join(" ", "Java", "is", "fun");

        long count = Stream.of("a", "b", "c", "a").collect(Collectors.counting());

        long count1 = Stream.of("a", "b", "c", "a").count();

        int total = Stream.of(1, 2, 3).collect(Collectors.summingInt(Integer::intValue));
        int total1 = Stream.of(1, 2, 3).mapToInt(Integer::intValue).sum();

        int max = Stream.of(1, 2, 3).max(Comparator.comparingInt(Integer::intValue)).get();

        int max1 = Stream.of(1, 2, 3).mapToInt(i -> i).max().getAsInt();


        double avg = Stream.of(1.0, 2.0, 3.0).collect(Collectors.averagingDouble(d -> d));

        List<String> items = List.of("apple", "banana", "avocado", "blueberry");

        Map<Character, List<String>> grouped = items.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));

        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        Map<Boolean, List<Integer>> partitioned = nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));


        Map<String, List<Integer>> nameLengths = Stream.of("Alice", "Bob", "Alex")
                .collect(Collectors.groupingBy(
                        s -> s.substring(0, 1),
                        Collectors.mapping(String::length, Collectors.toList())
                ));

        // Java 9+
        Map<String, List<String>> filtered = List.of("Ant", "Apple", "Bat", "Banana").stream()
                .collect(Collectors.groupingBy(
                        s -> s.substring(0, 1),
                        Collectors.filtering(s -> s.length() > 3, Collectors.toList())
                ));


    }
}
