package com.tech.subash.thread.completable;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class AllOff {
    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Result 1";
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Result 2";
        });

        CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2);

         // Without join(), code below runs immediately, even if f1 and f2 aren't done
        all.join();  // <-- This blocks until f1 and f2 complet
        System.out.println(f1.join()); // safe to call after all.join()
        System.out.println(f2.join());

    }
}
