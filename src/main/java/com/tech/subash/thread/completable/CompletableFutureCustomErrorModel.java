package com.tech.subash.thread.completable;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.*;
import java.util.*;


@Data
@AllArgsConstructor
class Result<T> {

   private T value;
   private Throwable error;

    public boolean isSuccess() {
        return error == null;
    }
}

public class CompletableFutureCustomErrorModel {

    public static void main(String[] args) {
        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Error in f1");
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> "Success in f2");

        List<CompletableFuture<Result<String>>> safeFutures = List.of(f1, f2).stream()
            .map(future ->
                future.handle((value, ex) -> new Result<>(value, ex))
            ).toList();

        // Wait for all
        CompletableFuture.allOf(safeFutures.toArray(new CompletableFuture[0])).join();

        safeFutures.stream()
                .map(CompletableFuture::join)
                .forEach(result -> {
                    if (result.isSuccess()) {
                        System.out.println("Success: " + result.getValue());
                    } else {
                        System.out.println("Failed: " + result.getError().getMessage());
                    }
                });

    }
}
