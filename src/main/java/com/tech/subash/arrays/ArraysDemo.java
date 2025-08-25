package com.tech.subash.arrays;

import java.util.Arrays;

public class ArraysDemo {

    public static void main(String[] args) {
        int elementToBeAdd = 20;
        int oldArray [] = new int[] {1,2};
        int len = oldArray.length;  // 2
        int newArray [] = Arrays.copyOf(oldArray, len +1 );
        newArray[len] = elementToBeAdd;
        System.out.println(Arrays.toString(newArray));
    }
}
