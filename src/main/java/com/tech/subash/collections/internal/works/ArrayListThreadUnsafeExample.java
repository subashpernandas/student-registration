package com.tech.subash.collections.internal.works;

import java.awt.desktop.SystemEventListener;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListThreadUnsafeExample {
    public static void main(String[] args) {
       ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <=5; i++) {
            list.add(i);
        }

        // Thread 1 → iterating
        Thread t1 = new Thread(() -> {
            //list.parallelStream().forEach(System.out::println);
           try {
                for (Integer num : list) {
                    System.out.println("Iterating: " + num);
                }
            } catch (ConcurrentModificationException e) {
               e.printStackTrace();
           }
        });

        // Thread 2 → modifying
        Thread t2 = new Thread(() -> {
            System.out.println("Modifying list...");
            list.add(99);   // modification while iteration
        });

        t1.start();
        t2.start();

    }
}
