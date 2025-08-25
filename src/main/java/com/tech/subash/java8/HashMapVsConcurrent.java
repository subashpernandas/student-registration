package com.tech.subash.java8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class HashMapVsConcurrent {

    // FAIL-FAST, CONCURRENCY LEVEL, PERFORMANCE
    public static void main(String[] args) {
        // HASHMAP IF SAME KEY WE CAN MODIFY WITH VALUES BUT
        // NOT ABLE TO NEWLY INSERT & NOT THREAD SAFE
        // ALLOWS NULL KEY AND VALUES

        // BUT IN CONCURRENT HASHMAP WE CAN NEWLY INSERT
        // THREAD SAFE
        // DOESN'T ALLOW ANY NULL KEY AND VALUES
        // ATOMIC OPERATION
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("A", "1");
        concurrentHashMap.put("B", "2");
        concurrentHashMap.putIfAbsent("A", "A++");
        concurrentHashMap.computeIfAbsent("C", k -> expensiveMethod());
        concurrentHashMap.replace("B", "2", "B++");

        for (String key : concurrentHashMap.keySet()) {
           // concurrentHashMap.put("C", "3"); // Throws ConcurrentModificationException
        }
        System.out.println(concurrentHashMap);

    }

    private static String expensiveMethod() {
        return "C++";
    }
}
