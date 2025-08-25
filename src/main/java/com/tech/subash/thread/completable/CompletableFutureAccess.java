package com.tech.subash.thread.completable;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureAccess {
    public static void main(String[] args) {

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Doing Supply async..." + Thread.currentThread().getName());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 42;
        }).thenAccept(result -> {
            System.out.println("Result: " + result + " "+ Thread.currentThread().getName());
        });

        future.join();
        System.out.println("Doing something else..." + Thread.currentThread().getName());
    }
}
