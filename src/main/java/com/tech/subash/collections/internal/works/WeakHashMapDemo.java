package com.tech.subash.collections.internal.works;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<Object, Integer> weakHashMap = new WeakHashMap<>();
        Object objectForZ = new Object();
        Object objectForC = new Object();
        Object objectForY = new Object();
        Object objectForD = new Object();


        weakHashMap.put(objectForZ, 26);
        weakHashMap.put(objectForC, 3);
        weakHashMap.put(objectForY, 25);
        weakHashMap.put(objectForD, 4);
        System.out.println("Weak Hash Map { It will Automatic CleanUp any Key is  Set as Null } Before Its Size " + weakHashMap.size());

        objectForZ = null;
        System.gc();
        Thread.sleep(1000);
        System.out.println("Weak Hash Map { It will Automatic CleanUp any Key is  Set as Null } After Set as Null " + weakHashMap.size());

    }
}
