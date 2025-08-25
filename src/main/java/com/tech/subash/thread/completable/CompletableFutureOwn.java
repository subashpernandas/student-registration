package com.tech.subash.thread.completable;


import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CompletableFutureOwn {
    public static void main(String[] args) {
        List<CompletableFuture<String>> list = getGroupDetails(10);
        list.forEach(future -> future.thenAccept(System.out::println));
        CompletableFuture<Void> allOf = CompletableFuture.allOf(list.toArray(new CompletableFuture[0]));
        allOf.join();

        CompletableFuture<List<String>> completableFuture = CompletableFuture.supplyAsync(() -> List.of("a", "b"));
        completableFuture.thenApply(List::toArray).thenAccept(array -> System.out.println(Arrays.toString(array)));
        System.exit(0);
        String[] array = completableFuture.join().toArray(String[]::new);
        System.out.println(Arrays.toString(array));
    }

    public static List<CompletableFuture<String>> getGroupDetails(int noOfThread) {
        ExecutorService executorService = Executors.newFixedThreadPool(noOfThread);
        List<CompletableFuture<String>> list = IntStream.range(0, 10).mapToObj(i -> {
            return CompletableFuture.supplyAsync(() -> {
                if (i == 5) {
                    throw new RuntimeException("exception occured in index " + i);
                }
                System.out.println("Thread Name " + Thread.currentThread().getName());
                return "customer-Id " + i;
            }, executorService).handle((response, exception) -> {
                if (exception != null) {
                    return "error occured " + i;
                } else {
                    return response.concat(" success");
                }
            });
        }).toList();
        executorService.shutdown();
        return list;
    }
}
