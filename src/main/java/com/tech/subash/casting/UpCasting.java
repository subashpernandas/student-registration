package com.tech.subash.casting;

/*
Upcasting means treating a subclass object as an instance of its superclass.

It is always safe and is done automatically by the compiler (implicit casting).

Because in a class hierarchy, the subclass is considered "below" the superclass.
Casting from subclass → superclass is like "moving up".

Upcasting is automatic, safe, and used for polymorphism.

After upcasting, only the methods available in the superclass are accessible — unless they're overridden.

Actual object behavior is preserved due to dynamic method dispatch.
 */

public class UpCasting {
    public static void main(String[] args) {
        Dog dog = new Dog();  // No casting in this line.
        Animal animal = dog; // 👈 Upcasting (Dog → Animal)
        dog.bark();
        dog.speak();

        animal.speak(); // OK
        // animal.bark(); ❌ Not accessible — reference type is Animal
    }
}
