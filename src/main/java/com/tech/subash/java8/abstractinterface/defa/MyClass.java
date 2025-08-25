package com.tech.subash.java8.abstractinterface.defa;

public class MyClass implements A, B {

    @Override
    public void greet() {
        System.out.println("greet");
        A.super.greet();
    }


    public static void main(String[] args) {
        A a = new MyClass();
        a.greet();
    }
}
