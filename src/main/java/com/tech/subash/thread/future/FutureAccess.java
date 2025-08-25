package com.tech.subash.thread.future;

import java.util.concurrent.*;

public class FutureAccess {

    // The Future interface provides only basic blocking methods
    // get() && cancel() && isDone() && isCancelled()
    // When combine multiple async task => No
    // When chain multiple task => No

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // Step 1: Submit a task
        Future<Integer> future = executorService.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 10 / 2;
        });

        // Step 2: Block and get the result, then Manually run another task
        System.out.println("Doing something else..." + Thread.currentThread().getName());

        future.cancel(true);
        System.out.println(" is cancelled " + future.isCancelled());
        try {
            int result = future.get();  // Blocking using get()
            int finalResult = result * 2;
            System.out.println("Final result: " + finalResult);
            executorService.shutdown();
        } catch (Exception ie ) {
            executorService.shutdown();
        }

        // No chaining is here
        //  future.thenApply(...).thenAccept(...);
    }
}
