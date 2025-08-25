package com.tech.subash.polymorphism.method.hiding;

/*
Method Hiding (Not Overriding)
Static methods belong to the class, not to an object.
They are resolved at compile time using the reference type, not the object type.
Static methods are not overridden, they are hidden — this is not runtime polymorphism.
 */

class A {
    static void show() {
        System.out.println("A");
    }
}

class B extends A {
    static void show() {
        System.out.println("B");
    }
}

public class MethodHiding {
    public static void main(String[] args) {
        A obj = new B();
        obj.show();  // Output: A (not B!)
    }
}
