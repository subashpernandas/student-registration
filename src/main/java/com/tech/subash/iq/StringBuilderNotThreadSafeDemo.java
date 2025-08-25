package com.tech.subash.iq;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringBuilderNotThreadSafeDemo {

    public static void main(String[] args) throws InterruptedException {
        StringBuilder builder = new StringBuilder();

        for(int j = 0; j < 100; j++ ) {
            Runnable runnable = () -> {
                for (int i = 0; i < 1000; i++) {
                    builder.append("A");
                }
                /* builder.append("A".repeat(100)); We are use for the for loop instead
                 */
            };

            Thread thread = new Thread(runnable);
            Thread thread1 = new Thread(runnable);

            thread.start();
            thread1.start();
            thread.join();
            thread1.join();

            int expectedLength = 1000 * 2;
            int actualLength = builder.length();

            log.info("Expected Length {} , Actual length {} , Iteration {}  " ,expectedLength,  actualLength, j);

            if (actualLength != expectedLength) {
                throw new RuntimeException("exception occured");
            }
            builder.setLength(0);
        }
    }
}

