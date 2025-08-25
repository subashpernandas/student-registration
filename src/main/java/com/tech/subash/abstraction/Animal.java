package com.tech.subash.abstraction;

/*
Q: Can an abstract class have a constructor in Java? If yes,
 what’s the purpose if you can't instantiate it?
 */

public abstract class Animal {
    Animal() {
        System.out.println("Animal constructor called");
    }
    abstract void sound();
}
