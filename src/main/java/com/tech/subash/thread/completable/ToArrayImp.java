package com.tech.subash.thread.completable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ToArrayImp {
    public static void main(String[] args) {

        List<CompletableFuture<String>> userCompleteList = getCompletableFuturesWithProperExceptionHanders(10);
        List<String> listOfCompletedFuture = userCompleteList.stream().map(CompletableFuture::join).toList();
        listOfCompletedFuture.forEach(System.out::println);

        // Way of Accessing in II
        userCompleteList.forEach(future ->
                future.thenAccept(result -> System.out.println("Got result: " + result))
        );

        //  Way of Accessing in III
        CompletableFuture<List<String>> completableFuture = CompletableFuture
                .allOf(userCompleteList.toArray(new CompletableFuture[0]))
                .thenApply(v ->
                        userCompleteList.stream()
                                .map(CompletableFuture::join)
                                .collect(Collectors.toList())
                );

        System.out.println("3 method " +completableFuture.join());

        CompletableFuture<List<String>> futureList = CompletableFuture.supplyAsync(() ->
                Arrays.asList("Alice", "Bob", "Charlie"));

        // Convert to array (blocking for result)
        //String[] array = futureList.join().toArray(new String[0]); // Block for using join
        //System.out.println(Arrays.toString(array));

        // You want the result asynchronously (non-blocking)
       CompletableFuture<String[]> futureArray = futureList.thenApply(list -> list.toArray(new String[0]));
        futureArray.thenAccept(arr -> {
            for (String name : arr) {
                System.out.println("elements in string "+name);
            }
        });

        // For Stream
        CompletableFuture<Stream<String>> futureStream = CompletableFuture.supplyAsync(() ->
                Stream.of("One", "Two", "Three"));

        CompletableFuture<String[]> arrayFuture = futureStream.thenApply(stream -> stream.toArray(String[]::new));
        arrayFuture.thenAccept(arr -> System.out.println(Arrays.toString(arr)));

    }

    public static List<CompletableFuture<String>> getCompletableFuturesWithProperExceptionHandling(int count) {
        ExecutorService executor = Executors.newFixedThreadPool(count); // 10 threads for 10 tasks
        AtomicInteger index = new AtomicInteger(0);

        List<CompletableFuture<String>> list = IntStream.range(0, count).mapToObj(i ->
                CompletableFuture.supplyAsync(() -> {
                    if (i == 5) {
                        throw new RuntimeException("Something went wrong at index " + i);
                    } else {
                        String msg = "message From Handling " + index.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() + " -> " + msg);
                        return msg;
                    }
                }, executor).exceptionally(ex -> {
                    System.err.println("Exception in task " + i + ": " + ex.getMessage());
                    return "error at index " + i;
                })
        ).toList();

        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        executor.shutdown(); // Now it's safe to shut down
        return list;
    }

    public static List<CompletableFuture<String>> getCompletableFuturesWithProperExceptionHanders(int count) {
        ExecutorService executor = Executors.newFixedThreadPool(count); // 10 threads for 10 tasks
        AtomicInteger index = new AtomicInteger(0);

        List<CompletableFuture<String>> list = IntStream.range(0, count).mapToObj(i ->
                CompletableFuture.supplyAsync(() -> {
                    if (i == 5) {
                        throw new RuntimeException("Something went wrong at index " + i);
                    } else {
                        String msg = "message From Handler " + index.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() + " -> " + msg);
                        return msg;
                    }
                }, executor).handle((result,ex ) -> {
                    if(ex != null) {
                        System.err.println("Exception in task " + i + ": " + ex.getMessage());
                        return "error at index " + i;
                    } else {
                        return result;
                    }
                })
        ).toList();

        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        executor.shutdown(); // Now it's safe to shut down
        return list;
    }
}
