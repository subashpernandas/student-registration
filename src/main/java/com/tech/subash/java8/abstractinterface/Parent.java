package com.tech.subash.java8.abstractinterface;

public class Parent {
    public void greet() {
        System.out.println("Hello from Parent class");
    }

    interface A {
        default void greet() {
            System.out.println("Hello from Interface A");
        }
    }

    static class Child extends Parent implements A {
        // No override needed
    }

    // If a class in the inheritance chain has a method with the same signature,
    // it takes precedence — even if it's not marked default
    public static void main(String[] args) {
       new Child().greet();  // Hello from Parent class
    }
}
