package com.tech.subash.design.patterns.singleton;

public class SingletonDemoAccess {
    public static void main(String[] args) {
        SingletonDemo singletonDemo =  SingletonDemo.getInstance();
        System.out.println(singletonDemo.hashCode());

        SingletonDemo singletonDemo2 =  SingletonDemo.getInstance();
        System.out.println(singletonDemo2.hashCode());
    }
}
