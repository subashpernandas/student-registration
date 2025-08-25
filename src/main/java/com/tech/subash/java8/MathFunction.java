package com.tech.subash.java8;

import java.util.*;
import java.util.stream.Collectors;

public class MathFunction {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,4,2,9,100);

        // FIND MAX
        Optional<Integer> usingMax = list.stream().max(Comparator.comparingInt(Integer::intValue));
        System.out.println("max "+ usingMax.get());

        Optional<Integer> max = list.stream().collect(Collectors.maxBy(Integer::compareTo));
        System.out.println("max "+ max.get());

        // FIND SUM
        Integer summingInt = list.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("summingInt "+ summingInt);

        int sumUsingMapToInt = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("summingInt "+ sumUsingMapToInt);

        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum using reduce " + sum);

        IntSummaryStatistics summaryStatistics = list.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("summaryStatistics " +summaryStatistics);

        // SORTED
        List<Integer> sortedList = list.stream().sorted().toList();
        System.out.println("sorted list " + sortedList);




    }
}
