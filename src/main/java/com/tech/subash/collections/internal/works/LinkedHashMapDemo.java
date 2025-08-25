package com.tech.subash.collections.internal.works;

import java.util.LinkedHashMap;
import java.util.Map;

/*
   Null Keys => 1 => Allowed
   Null Values => Allowed
   To Maintain Insertion Order
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        // Default Capacity / load Factor and Final One AccessOrder
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("z", 26);
        linkedHashMap.put("c", 3);
        linkedHashMap.put("y", 25);
        linkedHashMap.put("d", 4);

        linkedHashMap.put(null,null);
        linkedHashMap.put(null,32);
        linkedHashMap.put(null,44);
        linkedHashMap.put(null,889);


        System.out.println("Linked Hash Map { Maintain Insertion Order} " + linkedHashMap);

        System.out.println("\n");
        // Access Order Mode
        //linkedHashMap.get("c");
       // System.out.println("Linked Hash Map { Maintain Access Order} " + linkedHashMap);


    }
}
