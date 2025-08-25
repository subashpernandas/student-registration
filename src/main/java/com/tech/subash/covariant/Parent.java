package com.tech.subash.covariant;

/*
Covariant return types are allowed —
the return type in the overridden method can be a subclass of the original return type.
 */

class Parent {
    Number getValue() {
        return 10;
    }
}

class Child extends Parent {
    @Override
    Integer getValue() {
        return 20;
    }

    public static void main(String[] args) {
        Child child = new Child();
        //int number = (int) parent.getValue();
        Integer number = child.getValue(); // No Cast Need
        System.out.println(" number " + number);

        // Up Casting
        Parent parent = new Child();

        // Up Casting (implicit)
        Child childRef = new Child();
        Parent animal = childRef;

        // Down Casting
        Child parent1 = (Child) parent;

    }
}
