package com.tech.subash.solid.principle.liskov;

public class RefinedOstrich implements RefinedBird {
    @Override
    public void eat() {
        System.out.println("Ostrich can Eat only Veggies");
    }
}
