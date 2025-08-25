package com.tech.subash.java8.abstractinterface;

public class Sparrow extends Bird {
    Sparrow(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Sparrow can able to fly..");
    }

    public static void main(String[] args) {
        Bird animal = new  Sparrow("sparrow");
        animal.fly();
        animal.eat();
    }
}
