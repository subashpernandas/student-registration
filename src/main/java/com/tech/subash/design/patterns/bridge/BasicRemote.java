package com.tech.subash.design.patterns.bridge;

public class BasicRemote extends  RemoteControl {

    private  boolean isOn = false;
    private int volume = 10;
    public BasicRemote(Device device) {
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
}
