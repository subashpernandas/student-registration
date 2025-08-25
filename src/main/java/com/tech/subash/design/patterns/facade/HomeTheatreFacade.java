package com.tech.subash.design.patterns.facade;

public class HomeTheatreFacade {

    private  DvdPlayer dvdPlayer;
    private  SoundSytems soundSytems;
    private  Lights lights;
    private  Projector projector;

    public HomeTheatreFacade(DvdPlayer dvdPlayer, SoundSytems soundSytems,
                             Lights lights, Projector projector){
        this.dvdPlayer = dvdPlayer;
        this.lights = lights;
        this.projector = projector;
        this.soundSytems = soundSytems;
    }

    public void watchMovie(String movie){
        System.out.println("Get Ready to Watch movie");
        lights.dim();
        projector.on();
        projector.wideScreenMode();
        soundSytems.on();
        soundSytems.setSurroundSound();
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie(){
        System.out.println("Shutting movie Theatre Down");
        lights.on();
        projector.off();
        soundSytems.off();
        dvdPlayer.off();
    }
}
