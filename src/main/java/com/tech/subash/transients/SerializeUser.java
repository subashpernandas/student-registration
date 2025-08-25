package com.tech.subash.transients;

import jakarta.persistence.EntityManager;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializeUser {


    public static void main(String[] args) throws Exception {
        Person person = new Person("subash", "pass@123", "IT");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.ser"));
        out.writeObject(person);
        out.close();

       person.printInfo();
    }
}
