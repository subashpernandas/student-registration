package com.tech.subash.design.patterns.bridge;

public class Radio implements  Device {
    @Override
    public void turnOn() {
        System.out.println("Radio turned on..");
    }

    @Override
    public void turnOff() {
        System.out.println("Radio turned off..");
    }

    @Override
    public void setVolume(int vol) {
        System.out.println("Radio volume set to.. "+vol);
    }
}
