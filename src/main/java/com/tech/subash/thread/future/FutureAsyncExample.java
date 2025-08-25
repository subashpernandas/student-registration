package com.tech.subash.thread.future;

import java.util.concurrent.*;

public class FutureAsyncExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Submit a task asynchronously
        Future<Integer> future = executor.submit(() -> {
            System.out.println("Result: Exe "  + " "+ Thread.currentThread().getName()); // Thread pool
            Thread.sleep(5000); // Simulate long computation
            return 42;
        });

        // Later, get the result (this blocks until result is ready)
        try {
            int result = future.get();  // Blocking using get()
            int finalResult = result * 2;
            System.out.println("Result:  " + result + " "+ Thread.currentThread().getName()); // main
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }
        // Meanwhile, the main thread can do other things
        System.out.println("Doing something else while the task runs..." + Thread.currentThread().getName());
        executor.shutdown();

        // No chaining is here
        // future.thenApply(...).thenAccept(...);
    }
}
