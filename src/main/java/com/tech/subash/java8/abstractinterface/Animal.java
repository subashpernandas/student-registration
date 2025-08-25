package com.tech.subash.java8.abstractinterface;

public interface Animal {
    String name = "";
     default void eat(String name){
        System.out.println(name+" Can eat");
    }

    static void hunt(String name){
        System.out.println(name+" Can able to Hunt");
    }

    abstract void run() ;
}
