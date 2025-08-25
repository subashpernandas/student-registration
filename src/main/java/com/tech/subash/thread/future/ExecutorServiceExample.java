package com.tech.subash.thread.future;

import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        for (int i = 0; i < 100; i++) {
            executor.submit(() -> {
                System.out.println(  Thread.currentThread().getName());
            });
        }
        
        executor.shutdown();
    }
}
