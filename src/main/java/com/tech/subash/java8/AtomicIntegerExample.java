package com.tech.subash.java8;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet(); // Atomically increments by 1
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final counter value: " + counter.get());  // Expected: 2000
        atomicUsage();
    }

    public static void atomicUsage() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int initialValue = atomicInteger.get();
        System.out.println(" initialValue " +  initialValue); // 0
        int getAndIncrement = atomicInteger.getAndIncrement();
        System.out.println(" getAndIncrement " +  getAndIncrement); // 0
        int incrementAndGet = atomicInteger.incrementAndGet();
        System.out.println(" incrementAndGet "+ incrementAndGet); // 2
        int addAndGet = atomicInteger.addAndGet(incrementAndGet); //incrementAndGet * 2
        System.out.println(" addAndGet "+ addAndGet);
        atomicInteger.set(10);
        System.out.println(" After Set "+ atomicInteger.get());

        boolean b = atomicInteger.compareAndSet(9, 11);
        System.out.println("b "+ b); // success only set otherwise not set 11
        System.out.println(" after success "+ atomicInteger.get());

    }
}
