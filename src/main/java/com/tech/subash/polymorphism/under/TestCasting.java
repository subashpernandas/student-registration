package com.tech.subash.polymorphism.under;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("Dog barks");
    }
    void wagTail() {
        System.out.println("Dog wags tail");
    }
}

class Cat extends Animal {
    @Override
    void speak() {
        System.out.println("Cat meows");
    }
    void scratch() {
        System.out.println("Cat scratches");
    }
}

public class TestCasting {
    public static void main(String[] args) {
        
        // ✅ Upcasting (Implicit)
        Animal a = new Dog(); // Dog object in Animal reference
        a.speak(); // Runtime dispatch → Dog's speak()

        // ❌ a.wagTail(); // Compile-time error: not in Animal
        
        // ✅ Downcasting (Explicit)
        Dog d = (Dog) a; // Safe, because 'a' really refers to a Dog
        d.wagTail();     // Now Dog-specific method is accessible
        
        // ❌ Unsafe downcast (will throw ClassCastException)
        Animal a2 = new Cat(); // Cat object
        try {
            Dog d2 = (Dog) a2; // Compiles, but fails at runtime
            d2.wagTail();
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: Cannot cast Cat to Dog");
        }

        // ✅ Safe check before downcasting
        if (a2 instanceof Dog) {
            Dog safeDog = (Dog) a2;
            safeDog.wagTail();
        } else {
            System.out.println("a2 is not a Dog, so skipping downcast");
        }
    }
}
