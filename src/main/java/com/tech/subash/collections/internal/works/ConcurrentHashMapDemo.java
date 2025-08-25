package com.tech.subash.collections.internal.works;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
     Null Keys => Not Allowed
     Null Values => Not Allowed
     Synchronized & Thread Safe
     Bucket Level Synchronization since Java 8
     No Concurrent Modification Exception => Weakly consistent Iterator

 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> concurrentHahMap = new ConcurrentHashMap<>();
        concurrentHahMap.put("z",26);
        concurrentHahMap.put("c",3);
        concurrentHahMap.put("y",25);
        concurrentHahMap.put("d",4);
        // concurrentHahMap.put("z1",null);  NPE
        // concurrentHahMap.put(null, 32);  NPE
        System.out.println("Tree Map { Order Based On Key } " + concurrentHahMap);

        for (String s : concurrentHahMap.keySet()) {
            if(s.equals("z")){
                concurrentHahMap.put("s",32);
            }
        }
        System.out.println("Tree Map {We can Directly Remove & Add }"+ concurrentHahMap);
    }
}
