package com.tech.subash.design.patterns.state;

public class IdentificationAccess {

    public static void main(String[] args) {
        CitizenIdentifictionContext citizenIdentifictionContext = new CitizenIdentifictionContext();
        citizenIdentifictionContext.identificationCall("949867018092");
        citizenIdentifictionContext.setCitizenIdentificationProcess(new PanIdentification());
        citizenIdentifictionContext.identificationCall("949867018092");
        citizenIdentifictionContext.setCitizenIdentificationProcess(new AadhaarMisidentifications());
        citizenIdentifictionContext.identificationCall("949867018092");
    }
}
