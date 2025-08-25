package com.tech.subash.thread.completable;

import java.util.concurrent.CompletableFuture;

public class WhenComplete {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            if (true) {
                throw new RuntimeException("Boom");
            }
            return "Success";
        }).whenComplete((result, ex) -> {
            if (ex != null) {
                System.out.println("Error happened: " + ex.getMessage());
            } else {
                System.out.println("Success: " + result);
            }
        });

        System.out.println(future.join());
        System.out.println("Hello");


    }
}
