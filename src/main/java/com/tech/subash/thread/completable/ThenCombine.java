package com.tech.subash.thread.completable;

import java.util.concurrent.CompletableFuture;

public class ThenCombine {
    public static void main(String[] args) {
        CompletableFuture<String> studentFuture = CompletableFuture.supplyAsync(() -> getStudentName());
        CompletableFuture<String> parentFuture = CompletableFuture.supplyAsync(() -> getStudentsFatherName());
        studentFuture.thenCombine(parentFuture, (student, parent) -> student.concat("" + parent));
        System.out.println(studentFuture.join());
    }

    private static String getStudentName() {
        return "subash";
    }

    private static String getStudentsFatherName() {
        return "pernandas";
    }
}
