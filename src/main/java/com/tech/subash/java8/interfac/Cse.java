package com.tech.subash.java8.interfac;

public class Cse implements Dept {
    @Override
    public void studentRegistration() {
        System.out.println("student reg");
    }

    @Override
    public void codingClassForIT() {
        System.out.println("Cse will join");

        Dept.super.codingClassForIT();
    }

    public static void main(String[] args) {
        Cse dept = new Cse();
        dept.studentRegistration();
        dept.codingClassForIT();
    }
}
