package com.tech.subash.java8.iq;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapToInt {
    public static void main(String[] args) {

        List<Integer> intL = List.of(1, 3, 7);
        int sum = intL.stream().mapToInt(Integer::valueOf).sum();
        System.out.println("sum " + sum);

        Stream<String> names = Stream.of("Alice", "Bob", "Charlie");

        IntStream lengths = names.mapToInt(String::length);
        lengths.forEach(System.out::println);

        names = Stream.of("Alice", "Bob", "Charlie");
        List<Integer> list = names.mapToInt(String::length).boxed().toList();
        System.out.println("list " + list);

        Supplier<Stream<String>> namesSupplier = () -> Stream.of("Alice", "Bob", "Charlie");

        IntStream lengths1 = namesSupplier.get().mapToInt(String::length);
        lengths1.forEach(System.out::println);

        List<Integer> list1 = namesSupplier.get().mapToInt(String::length).boxed().toList();
        System.out.println("list " + list1);

        DoubleStream prices = DoubleStream.of(19.99, 25.75, 30.49);
        IntStream truncated = prices.mapToInt(d -> (int) d);
        truncated.forEach(System.out::println);
    }
}
