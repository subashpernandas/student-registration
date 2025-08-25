package com.tech.subash.thread.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SupplyAsync {

    public static void main(String[] args) {

        CompletableFuture<String> studentCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    try {
                        return returnStudent();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .exceptionally(ex ->  "default");
        CompletableFuture<String> staffCompletableFuture = CompletableFuture.supplyAsync(() -> {
                    try {
                        return returnStaff();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
                .exceptionally(ex -> "default");

        System.out.println(studentCompletableFuture.join());
        System.out.println(staffCompletableFuture.join());
        System.out.println("main");

    }

    public  static String returnStudent() throws InterruptedException {
        String s = null;
        TimeUnit.MILLISECONDS.sleep(1000);
        return s.toUpperCase();
    }

    public  static String returnStaff() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(5000);
        return "pernandas.jv";
    }
}
