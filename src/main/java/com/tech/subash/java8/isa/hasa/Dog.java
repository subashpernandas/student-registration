package com.tech.subash.java8.isa.hasa;


public class Dog extends Animal {

    public void bark(){      // Inheritance, Tightly coupled
        System.out.println("Dog barks");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        //A concrete instantiation of a subclass (Dog)
        // Dog IS-A Animal
        dog.makeSound();
        dog.bark();


        Animal animal = new Dog();  //Polymorphism based on IS-A
        animal.makeSound();
    }
}
