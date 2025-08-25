package com.tech.subash.solid.principle.liskov;

public class RefinedSparrow implements RefinedFlyingBird {
    @Override
    public void fly() {
        System.out.println("Sparrow Can fly upto 2000m");
    }

    @Override
    public void eat() {
        System.out.println("Sparrow Eat's only small warms");
    }
}
