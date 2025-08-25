package com.tech.subash.java8.isa.hasa;

public class Car {
    private Engine engine = new Engine(); // HAS-A // Composition Field/member inside another class

    void drive() {
        engine.start();
        System.out.println("Car is moving");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.drive();
    }
}
