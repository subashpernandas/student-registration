package com.tech.subash.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThread {

    static int increment = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static final Object lock = new Object();

    public static void setIncrement()  {

        try {
            System.out.println("increment state " + Thread.currentThread().getState());
            TimeUnit.SECONDS.sleep(2);
        } catch(InterruptedException ie){
            System.out.println(ie.getMessage());
        }
        //increment++;
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                setIncrement();
                //System.out.println("Thread Name for count  and Count 11"+ Thread.currentThread().getName() + " "+ increment) ;

            }
        };

        Runnable runnable1 = () -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    setIncrement();
                }
            }
        };


        Thread customthread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                setIncrement();
            }
        });

        Thread customthread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                setIncrement();
            }
        });

        Thread[] threads = new Thread[5];
        for (int i= 0 ; i < 5; i++){
            threads[i] = new Thread(runnable1, "T" + i);
            System.out.println("state before start " + threads[i].getState());
            threads[i].start();
            System.out.println("state after start " + threads[i].getState());
        }

        Thread.sleep(5000); // give them time to start

        for(int i=0; i<5;i++){
            System.out.println("state before join Thread Name " + Thread.currentThread().getName()+ threads[i].getState());
            threads[i].join();
        }
        /*threads[0] = customthread;
        threads[1] = customthread2;
        threads[0].start();
        threads[1].start();
        threads[0].join();
        threads[1].join();


                /*Thread thread = new Thread(runnable);
        thread.setName("Custom Thread-1");
        Thread thread1 = new Thread(runnable);
        thread1.setName("Custom Thread-2");
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();*/
        System.out.println("Thread Name for total and Count Atomic " + Thread.currentThread().getName() + " " + atomicInteger.get());
    }
}
