package com.tech.subash.inheritence;

class Animal {
    public void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

class Puppy extends Dog {
    void weep() {
        System.out.println("Puppy weeps");
    }
}

public class MultiLevelInheritance {
    public static void main(String[] args) {
        Puppy p = new Puppy();

        p.eat();   // inherited from Animal
        p.bark();  // inherited from Dog
        p.weep();  // defined in Puppy
    }
}
