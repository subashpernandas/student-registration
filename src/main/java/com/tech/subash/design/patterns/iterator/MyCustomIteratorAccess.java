package com.tech.subash.design.patterns.iterator;

import java.util.Arrays;

public class MyCustomIteratorAccess {
    public static void main(String[] args) {

        MyCustomIteratorImpl<String> myCustomIterator = new MyCustomIteratorImpl<>(Arrays.asList("A","B","C"));
        MyCustomIterator<String> iterator = myCustomIterator.iterator();
        while (iterator.hasNext()){
            String nextValue = iterator.next();
            System.out.println("values using iterator by custom "+ nextValue);
        }

        MyCustomIteratorImpl<Integer> myCustomIntegerIterator = new MyCustomIteratorImpl<>(Arrays.asList(1,10,99,21,16));
        MyCustomIterator<Integer> integerIterator = myCustomIntegerIterator.iterator();
        while (integerIterator.hasNext()){
            Integer nextValue = integerIterator.next();
            System.out.println("values using iterator by custom "+ nextValue);
        }
    }
}
