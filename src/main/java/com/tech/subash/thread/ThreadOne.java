package com.tech.subash.thread;

public class ThreadOne extends Thread {

    @Override
    public void run() {
        System.out.println("Thread one extends call");
    }

    public static void main(String[] args) {

        ThreadOne threadOne = new ThreadOne();
        threadOne.start();
    }
}
