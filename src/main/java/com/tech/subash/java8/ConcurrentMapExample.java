package com.tech.subash.java8;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMapExample {

    public static void main(String[] args) throws InterruptedException {
            hashMap();
    }

    public static void concurrentHashMap() throws InterruptedException {
        Map<String, Integer> map = new ConcurrentHashMap<>();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                map.merge("key", 1, Integer::sum);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final value: " + map.get("key")); // Expected: 3000
    }

    public static void hashMap() throws InterruptedException {
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                synchronized (map) {
                    map.put("key", map.getOrDefault("key", 0) + 1);
                }
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("Final value: " + map.get("key")); // Expected: 3000
    }
}
