package com.tech.subash.inheritence;

/*
Inheritance is a mechanism in Java where one class (child or subclass)
can acquire properties and behaviors (fields and methods)
from another class (parent or superclass).

Code reusability

Method overriding

Runtime polymorphism

Easy maintenance and extensibility

Constructors are not inherited.

Private members of the superclass are not accessible in subclass (directly).

You can override non-final, non-static, non-private methods.
 */

/*
 In Java,
 the reference type controls what you can access at compile time,
 but the object type controls what actually runs at runtime.

Compile-time view:
=====================
The reference is of type Parent, so you can only call methods declared in Parent.
If Child overrides a method from Parent, the overridden version runs at runtime.

Runtime view:
================
The object in memory is still a Child — nothing changes in the object layout.
You just have a more “restricted” reference.

 */

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Parent {

    void display() {
        log.info("Parent class");
    }
}

@Slf4j
class Child extends Parent {
    void display() {
        System.out.println("Child display");
    }
    void show() {
        log.info("Child class Show");
    }
}

public class SingleInheritance {
    public static void main(String[] args) {
        Parent p = new Child();

        // ✅ Compile time: OK, Parent has display()
        // ✅ Runtime: Calls Child's version (dynamic dispatch)
        p.display(); // Output: "Child display"

        // ❌ Compile time: Error - Parent doesn't have show()
        // p.show();

        // ✅ Compile time: OK after explicit cast
        Child c = (Child) p;

        // ✅ Runtime: Works, because object is actually a Child
        c.show();

        Parent p2 = new Parent();
        Child c2 = (Child) p2; // ✅ Compile time OK
        // ❌ Runtime: ClassCastException
        c2.show();
    }
}
