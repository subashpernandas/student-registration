package com.tech.subash.singleton;

public enum SingletonEnum {
    INSTANCE;

    private int counter = 0;

    public void increment() {
        counter++;
        System.out.println("Counter: " + counter);
    }

    public static void main(String[] args) {
        Runnable task = () -> {
            SingletonEnum singleton = SingletonEnum.INSTANCE;
            singleton.increment();
            System.out.println(Thread.currentThread().getName() + " - HashCode: " + singleton.hashCode());
        };

        // Create and start multiple threads
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task, "Thread-" + i);
            thread.start();
        }
    }
}


