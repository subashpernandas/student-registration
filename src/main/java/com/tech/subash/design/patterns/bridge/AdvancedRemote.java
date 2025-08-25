package com.tech.subash.design.patterns.bridge;

public class AdvancedRemote extends  RemoteControl {
    private  boolean isOn = false;
    private int volume = 10;
    public AdvancedRemote(Device device) {
        super(device);
    }

    @Override
    void togglePower() {
        if(isOn){
            device.turnOff();
        } else {
            device.turnOn();
        }
        isOn = !isOn;
    }

    @Override
    void volumeUp() {
        volume++;
        device.setVolume(volume);
    }

    @Override
    void volumeDown() {
        volume--;
        device.setVolume(volume);
    }

    public void mute(){
        device.setVolume(0);
        System.out.println("Mute the Device..");
    }
}
