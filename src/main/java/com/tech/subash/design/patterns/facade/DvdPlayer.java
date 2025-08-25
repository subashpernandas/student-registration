package com.tech.subash.design.patterns.facade;

public class DvdPlayer {
    public void on(){
        System.out.println("Dvd Player On");
    }

    public void play(String movieName){
        System.out.println("Dvd Player Playing On "+ movieName);
    }

    public void off(){
        System.out.println("Dvd Player Off");
    }
}
