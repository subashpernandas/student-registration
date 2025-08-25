package com.tech.subash.transients;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeserializeUser {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.ser"));
        Person person = (Person) in.readObject();
        in.close();

        person.printInfo();
    }
}
