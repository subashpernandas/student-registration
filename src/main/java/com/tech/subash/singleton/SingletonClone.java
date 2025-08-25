package com.tech.subash.singleton;

public class SingletonClone implements Cloneable {
    private static SingletonClone instance = null;

    private SingletonClone() {

    }

    public static SingletonClone getInstance() {
        if (instance == null) {
            instance = new SingletonClone();
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("clone not supported");  // Prevention Of Avoid SingletonBreak using clone
    }

}
