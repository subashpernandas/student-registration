package com.tech.subash.java8.abstractinterface;

public class Panther implements  Animal {
    @Override
    public void run() {
        System.out.println("Panther Can able to run");
    }

    @Override
    public void eat(String name) {  // default method can override
       // System.out.println("Panther Can Eat well");
        Animal.super.eat(name);
    }

    public static void main(String[] args) {
        Animal animal = new Panther();
        animal.run();
        animal.eat("Panther"); // default
        Animal.hunt("Panther"); // static
    }
}
