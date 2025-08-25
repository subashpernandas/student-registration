package com.tech.subash.thread.completable;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ToArray {

    public static void main(String[] args) {

        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            if(true) throw new RuntimeException("exception");
            return "One";
        }).exceptionally(ex -> "exception occurred");

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Two");

        List<CompletableFuture<String>> futures = List.of(f1, f2);
        CompletableFuture<?>[] futureArray = futures.toArray(new CompletableFuture[0]);

        CompletableFuture<Void> all = CompletableFuture.allOf(futureArray);

        all.join(); // Waits for both to finish

        List<String> results = futures.stream()
                .map(f -> {
                    try {
                        return f.join(); // Safe because of .exceptionally()
                    } catch (Exception e) {
                        return "default"; // fallback if not handled earlier
                    }
                }).toList();
        System.out.println(results);
    }

}
