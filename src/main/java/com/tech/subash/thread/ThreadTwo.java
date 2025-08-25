package com.tech.subash.thread;

public class ThreadTwo implements Runnable , Dummy {
    @Override
    public void run() {
        System.out.println("Thread 2 implements call");
    }

    @Override
    public void call() {
        System.out.println("Call");
    }

    public static void main(String[] args) {
        Thread threadTwo = new Thread(new ThreadTwo());
        threadTwo.start();

        ThreadTwo threadTwo1 = new ThreadTwo();
        threadTwo1.call();
    }


}
