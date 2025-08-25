package com.tech.subash.design.patterns.state;

public class VoterIdentificationProcess implements CitizenIdentificationProcess{
    @Override
    public void authorizeAndVerifyCitizenShip(String aadhaarNo) {
        System.out.println("Voter Verified Against "+ aadhaarNo);
    }
}
