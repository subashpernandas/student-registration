package com.tech.subash.design.patterns.bridge;

public class SmartSpeaker implements Device {
    @Override
    public void turnOn() {
        System.out.println("Smart Speaker turned on..");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart Speaker turned off..");
    }

    @Override
    public void setVolume(int vol) {
        System.out.println("smart Speaker volume set to.. "+vol);
    }
}
