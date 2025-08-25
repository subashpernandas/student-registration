package com.tech.subash.collections.internal.works;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/*
   Fix It::
   -------
   List<Integer> list = Collections.synchronizedList(new ArrayList<>());
   Or
   List<Integer> list = new CopyOnWriteArrayList<>();
   Or
    synchronized (list) {
    list.add(item);
}
 */
public class NotThreadSafeExample {

    static int counter = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static synchronized void increment() {
        counter++;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        // Two threads trying to add to the list at the same time
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                //list.add(i);
               // increment();
                atomicInteger.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.err.println("error occurred " + e.getMessage());
        }
        System.out.println("Final size: " + atomicInteger.get());
    }
}
