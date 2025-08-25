package com.tech.subash.concurren.collection;

import java.util.*;
import java.util.concurrent.*;

public class MapIterationExample {

    public static void main(String[] args) throws InterruptedException {
        Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> concurrentMap = new ConcurrentHashMap<>();

        // Start threads to modify both maps
        Thread writer1 = new Thread(() -> writeToMap(syncMap, "SyncMap"));

        Thread writer4 = new Thread(() -> writeToMap(concurrentMap, "ConcurrentMap"));

        writer1.start();
        writer4.start();

        // Give writers a moment to start writing
        Thread.sleep(500);

        System.out.println("Iterating over synchronizedMap:");
        try {
            // This will likely throw ConcurrentModificationException
            for (Map.Entry<String, String> entry : syncMap.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
                Thread.sleep(50); // simulate slow iteration
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Exception in syncMap iteration: " + e);
        }

        System.out.println("\n Iterating over concurrentMap:");
        // No exception here, even if map is modified during iteration
        for (Map.Entry<String, String> entry : concurrentMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
            Thread.sleep(10);
        }

        writer1.join();
        writer4.join();
    }

    // Helper method to simulate writing to a map
    private static void writeToMap(Map<String, String> map, String prefix) {
        for (int i = 0; i < 500; i++) {
            map.put(prefix + "-Key" + i, "Value" + i);
           /* try {
                Thread.sleep(1); // simulate delay between writes
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }*/
        }
    }
}
