package com.tech.subash.solid.principle.liskov;

public class Scotty implements MotorCycle {

    @Override
    public void selfStart() {
        System.out.println("Scooty has start");
    }


    public static void main(String[] args) {
        MotorCycle motorCycle = new Scotty();
        motorCycle.selfStart();
    }
}
