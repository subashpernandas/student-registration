package com.tech.subash.thread.completable;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ConcurrentSceneriesUsingAnyOf {

    public static void main(String[] args) {

        CompletableFuture<String> studentFuture = CompletableFuture.supplyAsync(() -> getStudentName());
        CompletableFuture<Integer> parentFuture = CompletableFuture.supplyAsync(() -> getParentName());
        CompletableFuture<Object> any = CompletableFuture.anyOf(parentFuture, studentFuture);
        Map<String, Object> map = new HashMap<>();
        any.thenAccept(result -> {
            if (result instanceof String) {
                map.put("string",  result);
            } else if (result instanceof Integer) {
                map.put("int", (int) result);
            }
        }).thenRun( () -> log.info("map {} ", map));

        CompletableFuture<Void> allOf = CompletableFuture.allOf(parentFuture, studentFuture);
        allOf.join();
        // Now fetch results from original futures
        Integer parentResult = parentFuture.join();
        String studentResult = studentFuture.join();
        log.info("Parent: " + parentResult);
        log.info("Student: " + studentResult);

    }

    public static String getStudentName() {
        log.info("getStudent name call");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } return "subash";
    }

    public static Integer getParentName() {
        log.info("getParent name call");
        return 31;
    }
}
