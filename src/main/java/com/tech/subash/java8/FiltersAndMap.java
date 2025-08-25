package com.tech.subash.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class FiltersAndMap {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("subash","pernandas","savari",null);  // NOT THROW ANY EXCEPTION
        list.stream().filter(Objects::nonNull).forEach(System.out::println);

        List<String> immutableList =List.of("subash","pernandas","savari",null);  // THROW NPE EXCEPTION
        Set<Integer> set = immutableList.stream().filter(Objects::nonNull).map(String::length).collect(Collectors.toSet());
        System.out.println("set "+ set);

    }
}
