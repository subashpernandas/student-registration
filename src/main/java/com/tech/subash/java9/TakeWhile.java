package com.tech.subash.java9;

import java.util.List;

public class TakeWhile {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 4, 6, 8, 9, 10, 12);
        List<Integer> takeWhile = numbers.stream().takeWhile(n -> n % 2 == 0).toList();
        System.out.println(takeWhile);  // [2,,4,6,8] => If any False immediate quit the loop and collect

        List<Integer> dropWhile = numbers.stream().dropWhile(n -> n % 2 == 0).toList();
        System.out.println(dropWhile);  // [ 9, 10, 12 ]

    }
}
