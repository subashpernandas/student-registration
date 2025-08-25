package com.tech.subash.volatil;

import java.util.concurrent.atomic.AtomicInteger;
/*
The actual value is often less than the expected 2000, sometimes much less.
This shows race conditions.
 */

public class VolatileNotAtomic {
    //private static volatile int counter = 0;

    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            threadDemo();
            counter.set(0);
        }
    }

    public static void threadDemo() throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                //synchronized (VolatileNotAtomic.class) {
                counter.incrementAndGet();//++;  // not atomic even if counter is volatile
                //}
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Expected: 2000, Actual: " + counter);
    }
}
