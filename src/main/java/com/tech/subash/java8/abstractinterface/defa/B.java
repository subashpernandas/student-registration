package com.tech.subash.java8.abstractinterface.defa;

public interface B {
    default void greet() {
        System.out.println("Hello from A");
    }
}
