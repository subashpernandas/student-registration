package com.tech.subash.abstraction;

/*Yes, an abstract class can have a constructor in Java, even though
 it cannot be instantiated directly.
The constructor is called when a subclass is instantiated, and it helps initialize
common properties defined in the abstract class.
 */

public class AnimalAccess {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
    }
}
