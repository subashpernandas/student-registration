package com.tech.subash.iq;

public class AiBike extends MotorBike {
    public void aiBike() {
        System.out.println("Ai Bike invented by Subash.PS");
    }

    public static void main(String[] args) {

        MotorBike motorBike = new AiBike();
        motorBike.innovativeBike();
        motorBike.motorBike();

        AiBike aiBike = new AiBike();
        aiBike.innovativeBike();
        aiBike.motorBike();
        aiBike.aiBike();

    }
}
