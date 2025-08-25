package com.tech.subash.iq;

import java.util.List;
import java.util.stream.IntStream;

public class ThreadCreationUsingStream {
    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            System.out.println("Hello From " + Thread.currentThread().getName());
        };

        // Way Of 1
        List<Thread> streamThread = IntStream.range(0, 10)
                .mapToObj(i -> new Thread(runnable))
                .peek(Thread::start).toList();

        for (Thread t : streamThread) {
            t.join();
        }

        // Way Of 2
        Thread[] threadsArray = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threadsArray[i] = new Thread(runnable);
            threadsArray[i].start();
        }

        for (Thread t : threadsArray) {
            t.join();
        }

    }
}
