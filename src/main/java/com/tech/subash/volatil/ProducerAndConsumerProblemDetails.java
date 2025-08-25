package com.tech.subash.volatil;

public class ProducerAndConsumerProblemDetails {

    private final Object lock = new Object();
    private int value = 0;
    private boolean produced = false;

    public static void main(String[] args) {

        ProducerAndConsumerProblemDetails producerAndConsumerProblemDetails = new ProducerAndConsumerProblemDetails();
        Thread producerThread = new Thread (() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    producerAndConsumerProblemDetails.producer();
                    Thread.sleep(200);
                }
            } catch (Exception ie){
                System.out.println(ie.getMessage());
            }
        });

        Thread consumerThread = new Thread (() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    producerAndConsumerProblemDetails.consumer();
                    Thread.sleep(300);
                }
            } catch (Exception ie){
                System.out.println(ie.getMessage());
            }
        });

        producerThread.start();
        consumerThread.start();
    }

    private void producer() throws InterruptedException {
        synchronized (lock) {
            while (produced){
                lock.wait();
            }
            value++;
            produced= true;
            System.out.println("Produced "+ value);
            lock.notify();
        }
    }

    private void consumer() throws InterruptedException {
        synchronized(lock) {
            while (!produced){
                lock.wait();
            }
            produced= false;
            System.out.println("Consumed "+ value);
            lock.notify();
        }
    }
}
