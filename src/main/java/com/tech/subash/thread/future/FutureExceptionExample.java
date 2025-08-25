package com.tech.subash.thread.future;

import java.util.concurrent.*;
/*
Limitation	                            Explanation
------------------------------------------------------------------------
Only post-task exception handling	You can’t handle errors while the task is running
No built-in recovery logic         	You must catch and inspect manually
No fallback support	                You can't define alternate paths like in CompletableFuture
No chaining	                        So can't chain exception responses
 */
public class FutureExceptionExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Future<Integer> future = executor.submit(() -> {
            throw new IllegalArgumentException("Something went wrong!");
        });

        try {
            Integer result = future.get(); // ❗️ This will throw ExecutionException
            System.out.println("Result: " + result);
        } catch (ExecutionException e) {
            System.out.println("Caught exception: " + e.getCause()); // The real cause
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        }

        executor.shutdown();
    }
}
