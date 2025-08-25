package com.tech.subash.thread.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        supplyAsyncAlongWithThenAccept();
        //System.out.println("waiting for "+ Thread.currentThread().getName());
    }

    public static void supplyAsyncAlongWithThenAccept() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> longRunningTask())
                .exceptionally(e -> {
                    System.out.println("Exception: " + e.getMessage());
                    return "Default Result";
                });

        future.thenAccept(result -> {
            System.out.println("Result: " + result);
            System.out.println("Result for "+ Thread.currentThread().getName());
        });
        System.out.println("waiting for "+ Thread.currentThread().getName());

      //  doDatabaseProcess();
        future.join();
    }

    private static String longRunningTask() {

        String nullv = null;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } return nullv.toLowerCase();
    }

    public static void doDatabaseProcess(){
        System.out.println("DB Processing Thread Name "+ Thread.currentThread().getName());
    }
}
