package com.tech.subash.thread.completable;

import java.util.concurrent.CompletableFuture;

public class RunAsync {

    public static void main(String[] args) {
        String employeeId = "EMP-001";

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() ->
                        performThirdPartyAPI(employeeId)).thenRunAsync(
                                () -> updateDatabaseRegEmployeeDetail(employeeId));
        CompletableFuture.allOf(completableFuture).join();

        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            System.out.println("Initial task in thread: " + Thread.currentThread().getName());
        });

        // Runs a task after the previous stage is complete.
        // Runs in the same thread that completed the previous stage (could be async or main).
        // Doesn’t take the result of the previous stage (just ignores it).
        cf.thenRun(() -> {
            System.out.println("thenRun() in thread: " + Thread.currentThread().getName());
        });

        // Same as thenRun, but always runs asynchronously.
        // Doesn’t use the same thread of the previous stage.
        cf.thenRunAsync(() -> {
            System.out.println("thenRunAsync() in thread: " + Thread.currentThread().getName());
        });
    }

    private static void updateDatabaseRegEmployeeDetail(String employeeId) {
        System.out.println("updateDatabaseRegEmployeeDetail details  thread name " + employeeId + " " + Thread.currentThread().getName());
    }

    private static void performThirdPartyAPI(String employeeId) {
        System.out.println("performThirdPartyAPI details  thread name " + employeeId + " " + Thread.currentThread().getName());
    }
}
