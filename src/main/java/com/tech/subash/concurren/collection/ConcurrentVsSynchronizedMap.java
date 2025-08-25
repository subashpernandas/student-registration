package com.tech.subash.concurren.collection;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentVsSynchronizedMap {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());
        Map<String, String> concurrentMap = new ConcurrentHashMap<>();

        Runnable task1 = () -> {
            for (int i = 0; i < 100; i++) {
                syncMap.put(Thread.currentThread().getName() + "- Sync Map " + i, "val");
                concurrentMap.put(Thread.currentThread().getName() + "- Concurrent Map " + i, "val");
            }
        };

        Thread t1 = new Thread(task1, "T1");
        Thread t2 = new Thread(task1, "T2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("SynchronizedMap size: " + syncMap.size());
        System.out.println("ConcurrentHashMap size: " + concurrentMap.size());

        // Safe iteration of syncMap
        System.out.println("\nSyncMap iteration (manual sync):");
        //synchronized (syncMap) {
        for (Map.Entry<String, String> entry : syncMap.entrySet()) {
            System.out.println(entry.getKey());
            // break; // just one to keep it short
        }
        //}

        System.out.println("\nConcurrentMap iteration (no sync):");
        for (Map.Entry<String, String> entry : concurrentMap.entrySet()) {
            System.out.println(entry.getKey());
            //break; // just one to keep it short
        }
    }
}
