package com.tech.subash.design.patterns.bridge;

public abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device){
        this.device = device;
    }
    abstract  void togglePower();
    abstract  void volumeUp();
    abstract  void volumeDown();
}
