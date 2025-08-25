package com.tech.subash.collections.internal.works;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();

        //Vector<Integer> vector = new Vector<>(10,5);
        for(int i=0; i<10;i++) {
            vector.add(i);
            vector.remove(2);
        }

        System.out.println("size " +vector.size());
        System.out.println("capacity " + vector.capacity());
        vector.add(11);
        System.out.println("size after 11th add "+ vector.size());
        System.out.println(vector.capacity());

    }
}
