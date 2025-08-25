package com.tech.subash.java8.abstractinterface.defa;

public interface A {
    default void greet() {
        System.out.println("Hello from A");
    }
}
