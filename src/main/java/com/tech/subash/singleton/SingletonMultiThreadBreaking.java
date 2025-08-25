package com.tech.subash.singleton;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
public class SingletonMultiThreadBreaking {
    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            SingletonMultiThread singleton = SingletonMultiThread.getInstanceUpdated();
            log.info("Thread Name , HashCode  {} , {} ", Thread.currentThread().getName() , singleton.hashCode());
        };

        List<Thread> threadList = IntStream.range(1, 10).mapToObj(
                        i -> new Thread(task, "Thread-" + i)).peek(Thread::start).toList();

        for (Thread threadLis : threadList) {
            threadLis.join();
        }

    }
}
