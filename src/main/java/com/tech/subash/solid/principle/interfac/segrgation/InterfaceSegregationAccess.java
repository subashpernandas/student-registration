package com.tech.subash.solid.principle.interfac.segrgation;

public class InterfaceSegregationAccess {
    public static void main(String[] args) {
        RefinedWorker refinedWorker = new RefinedWorker();
        refinedWorker.eat();
        refinedWorker.work();

        RefinedRobot refinedRobot = new RefinedRobot();
        refinedRobot.work();
    }
}
