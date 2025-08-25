package com.tech.subash.design.patterns.bridge;

public class BridgePatternAccess {
    public static void main(String[] args) {

        Device tv = new SmartSpeaker();
        AdvancedRemote remoteControl = new AdvancedRemote(tv);
        remoteControl.togglePower();
        remoteControl.volumeUp();
        remoteControl.volumeDown();
        remoteControl.mute();

        Device radio = new Radio();
        RemoteControl remoteControlForRadio = new BasicRemote(tv);
        remoteControlForRadio.togglePower();
        remoteControlForRadio.volumeUp();
        remoteControlForRadio.volumeDown();

    }
}
