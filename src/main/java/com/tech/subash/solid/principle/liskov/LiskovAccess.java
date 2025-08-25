package com.tech.subash.solid.principle.liskov;

public class LiskovAccess {
    public static void main(String[] args) {
        RefinedBird refinedBird = new RefinedOstrich();
        refinedBird.eat();

        RefinedFlyingBird refinedFlyingBird = new RefinedSparrow();
        refinedFlyingBird.fly();
        refinedFlyingBird.eat();
    }
}
