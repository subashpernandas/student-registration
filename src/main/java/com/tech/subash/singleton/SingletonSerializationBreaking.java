package com.tech.subash.singleton;

import java.io.*;

public class SingletonSerializationBreaking {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
       SingletonSerialization singletonSerialization = SingletonSerialization.getInstance();

        ObjectOutputStream objectInputStream = new ObjectOutputStream(new FileOutputStream("ser.txt"));
        objectInputStream.writeObject(singletonSerialization);
        objectInputStream.close();


        ObjectInputStream objectOutputStream = new ObjectInputStream(new FileInputStream("ser.txt"));
        SingletonSerialization singletonSerialization1 = (SingletonSerialization) objectOutputStream.readObject();
        objectOutputStream.close();

        System.out.println(singletonSerialization.hashCode() + " "+ singletonSerialization1.hashCode());
        // 1018081122 380936215
    }
}
