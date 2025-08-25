package com.tech.subash.design.patterns.state;

public class CitizenIdentifictionContext {

    public CitizenIdentificationProcess citizenIdentificationProcess;

    public CitizenIdentifictionContext() {
        this.citizenIdentificationProcess = new VoterIdentificationProcess();
    }

     void setCitizenIdentificationProcess(CitizenIdentificationProcess citizenIdentificationProcess){
        this.citizenIdentificationProcess = citizenIdentificationProcess;;
    }

    public void identificationCall(String aadhaarNo){
        citizenIdentificationProcess.authorizeAndVerifyCitizenShip(aadhaarNo);
    }
}
