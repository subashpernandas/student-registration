package com.tech.subash.thread.completable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class ThenApply {
    // Used to transform the result of a CompletableFuture synchronously.
    // It takes the result of the stage, applies a function, and returns a new
    // CompletableFuture with the transformed value.
    public static void main(String[] args) {
        CompletableFuture<String> studentFuture = CompletableFuture.supplyAsync(() -> getStudentName());
        CompletableFuture<String> newStudentFuture = studentFuture.thenApply(name -> name.concat("pernandas"));
        log.info(newStudentFuture.join());

        CompletableFuture<String> transformedStudentNameFuture = studentFuture.thenApply(name -> "Student Name: " + name);

        CompletableFuture<String> parentFuture = CompletableFuture.supplyAsync(() -> getStudentsFatherName());

        CompletableFuture<String> fullDetailsFuture = transformedStudentNameFuture.thenCombine(parentFuture,
                (studentName, fatherName) -> studentName + ", Father Name: " + fatherName);
        log.info(fullDetailsFuture.join());

    }

    private static String getStudentName() {
        return "subash";
    }

    private static String getStudentsFatherName() {
        return "pernandas";
    }
}
