package com.tech.subash.thread.completable;

import java.util.concurrent.CompletableFuture;

public class ThenCompose {
    public static void main(String[] args) {
        CompletableFuture<String> studentFuture = CompletableFuture.supplyAsync(() -> getStudentName());
        CompletableFuture<String> parentFuture = studentFuture.thenCompose(studentName -> getFatherName(studentName));
        System.out.println(parentFuture.join());

    }

    private static String getStudentName() {
        return "subash";
    }

    private static CompletableFuture<String> getFatherName(String studentName) {
        return CompletableFuture.supplyAsync(() -> studentName.concat(" Pernanadas"));
    }
}
