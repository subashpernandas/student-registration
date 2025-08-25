package com.tech.subash.design.patterns.state;

public class AadhaarMisidentifications implements CitizenIdentificationProcess{
    @Override
    public void authorizeAndVerifyCitizenShip(String aadhaarNo) {
        System.out.println("Addhar Verified Done against "+ aadhaarNo);
    }
}
