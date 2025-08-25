package com.tech.subash.covariant;

/*
Covariant return types make your code:
More specific in subclasses
Cleaner and safer (fewer casts)
Better for fluent APIs or builder patterns.
This allows for more specific return types when working with inheritance and polymorphism.
Covariant return types make code more expressive and reduce the need for casting.
Without covariance, you'd be forced to return Animal and then downcast it like:
 */

class Animal {
    Object getValue() {
        return "parent";
    }
}

class Dog extends Animal {
    @Override
    String getValue() {
        return "child";
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        String r1 = dog.getValue(); // ✅ no cast
        Animal a = dog; // Up Casting
        Object r2 = a.getValue(); // Still Object from Animal reference
        System.out.println(r1 + " " + r2);
    }
}