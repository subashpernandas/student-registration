package com.tech.subash.java8.abstractinterface;

public abstract class Bird {

    private String name;  // instance variable
    private static String count; // static variable

    Bird(String  name){
        this.name = name;
    }
    public  void eat(){
        System.out.println(name+" Can eat");
    }

    public  abstract  void fly();

}
