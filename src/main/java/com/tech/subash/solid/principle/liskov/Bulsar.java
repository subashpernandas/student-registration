package com.tech.subash.solid.principle.liskov;

public class Bulsar implements GearMotorCycle {
    @Override
    public void gearUp() {
        System.out.println("gear up in Bulsar");
    }

    @Override
    public void gearDown() {
        System.out.println("gear down in Bulsar");
    }

    @Override
    public void selfStart() {
        System.out.println("Bulsar Start");
    }

    public static void main(String[] args) {

        GearMotorCycle bulsar = new Bulsar();
        bulsar.selfStart();
        bulsar.gearDown();
        bulsar.gearUp();
    }
}
