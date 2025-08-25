package com.tech.subash.thread;

public class BlockedExample {
    private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Runnable runnable = () -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " got the lock");
                try {
                    Thread.sleep(5000);
                    //lock.wait();
                } catch (InterruptedException ie) {
                    System.out.println(ie.getMessage());
                }
            }
        };

        Runnable runnable2 = () -> {
            synchronized (lock) {
                //lock.notify();
                System.out.println("Thread name and state " + Thread.currentThread().getName() + " Got the lock");
            }
        };

        Thread t = new Thread(runnable, "T1");
        Thread t2 = new Thread(runnable2, "T1");
        t.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(500);

        System.out.println("Thread 1 State "+ t.getState()); // TIMED_WAITING
        System.out.println("Thread 2 State "+ t2.getState()); // BLOCKED
        t.join();
        t2.join();
        System.out.println("Thread 1 State After join "+ t.getState()); // TERMINATED
        System.out.println("Thread 2 State After Join "+ t2.getState()); // TERMINATED

    }
}

