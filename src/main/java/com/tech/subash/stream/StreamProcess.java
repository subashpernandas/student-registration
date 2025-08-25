package com.tech.subash.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamProcess {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","c","b");

        System.out.println("List " + list.stream().map(n -> n.toUpperCase()).collect(Collectors.toSet()));
        list.forEach(System.out::println);

        System.out.println("\n");
        Supplier<Stream<String>> stream = () -> Stream.of("A","C");
        stream.get().forEach(System.out::println);
        List<String> liste = stream.get().filter(name -> name.equals("A")).collect(Collectors.toList());
        System.out.println("list "+ liste);

    }
}
