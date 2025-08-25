package com.tech.subash.design.patterns.state;

public class PanIdentification implements CitizenIdentificationProcess{
    @Override
    public void authorizeAndVerifyCitizenShip(String aadhaarNo) {
        System.out.println("Pan identification verified against "+ aadhaarNo);
    }
}
