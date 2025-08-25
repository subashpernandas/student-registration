package com.tech.subash.common.prgram;

import java.util.Arrays;
import java.util.Optional;

public class SecondLargest {
    public static int secondLargest(int[] nums) {
        if (nums.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third =Integer.MIN_VALUE;

        for (int n : nums) {
            if (n > first) {
                second = first;
                first = n;
            } else if (n > second && n != first) {
                second = n;
            }
        }

        for (int n : nums) {
            if ( n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n > second && n != first) {
                third = second;
                second = n;
            } else if ( n > third && n != second && n != first) {
                third = n;
            }
        }

        System.out.println("second  "+second  + " thrid "+ third );
        return second;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 3, 50, 23};
        System.out.println("Second Largest: " + secondLargest(arr));
        Integer optionalI = Arrays.stream(arr).distinct().boxed().sorted().skip(2).findFirst().orElseThrow(() -> new RuntimeException("index not "));
        System.out.println(optionalI);
    }
}
