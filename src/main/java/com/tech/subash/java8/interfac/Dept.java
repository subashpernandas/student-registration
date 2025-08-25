package com.tech.subash.java8.interfac;

public interface Dept {

    void studentRegistration();
    default void codingClassForIT() {
        System.out.println("Must be Joined IT Student If want anyothers will be join");
    }
    static void MustJoinIT() {
        System.out.println("Must be Joined All Student");
    }
}
