package com.tech.subash.design.patterns.facade;

public class FacadeAccess {
    public static void main(String[] args) {
        HomeTheatreFacade homeTheatreFacade = new HomeTheatreFacade(new DvdPlayer(), new SoundSytems(), new Lights(), new Projector());
        homeTheatreFacade.watchMovie("Shajakan");
        homeTheatreFacade.endMovie();
    }
}
