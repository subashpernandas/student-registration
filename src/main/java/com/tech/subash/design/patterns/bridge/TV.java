package com.tech.subash.design.patterns.bridge;

public class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV turned on..");
    }

    @Override
    public void turnOff() {
        System.out.println("TV turned off..");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("TV volume set to "+ volume);
    }
}
