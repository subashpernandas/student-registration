package com.tech.subash.thread.completable;

import org.springframework.http.HttpStatus;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
(Exception) Passed directly to Handlers - CompletableFuture
error handling via exceptionally() , handle()
--------------------------------------------------------
ExecutionException          - Future
Custom error handling       - Future (manual try/catch)
FallBack                    - Future - No

 */
public class CompletableFutureExceptionHandling {
    public static void main(String[] args) {
        CompletableFuture<?> completableFuture = CompletableFuture.supplyAsync(() -> {
            if (1 == 1) {
                throw new RuntimeException("1 != 1");
            }
            return "Subash Pernandas";
        }).handle((response, exception) -> {
            if(exception != null) {
                return new GenericException("Fallback value", HttpStatus.INTERNAL_SERVER_ERROR.value()); // Error also return
            } else {
                return response;
            }
        });
        System.out.println(completableFuture.join());


       CompletableFuture<?> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            if(1 == 2){
                throw  new RuntimeException("1 != 1");
            } return "Subash Pernandas";
        }).exceptionally(ex -> "Error value");
        System.out.println(completableFuture1.join());
    }
}
