package com.tech.subash.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class SingletonSerialization implements Serializable {

    private static SingletonSerialization singleton = new SingletonSerialization();

    private SingletonSerialization(){

    }

    public static SingletonSerialization getInstance(){
        if(singleton == null) {
            singleton = new SingletonSerialization();
            return singleton;
        } else {
            return singleton;
        }
    }

    // Ensures singleton after deserialization
    public Object readResolve() throws ObjectStreamException {
        return singleton;
    }
}
