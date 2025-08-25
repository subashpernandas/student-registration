package com.tech.subash.singleton;

public class SingletonDoubleChecking {
    public static void main(String[] args) {
        SingletonMultiThread singletonMultiThread = SingletonMultiThread.getInstanceForDoubleCheck();
        SingletonMultiThread singletonMultiThread1 = SingletonMultiThread.getInstanceForDoubleCheck();

        System.out.println(singletonMultiThread1.hashCode() + " "+ singletonMultiThread.hashCode());

    }
}
