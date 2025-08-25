package com.tech.subash.java8;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapVsHashTable {

    public static void main(String[] args) {
        Map<String, String> map  = new HashMap<>();
        map.put(null, "A++");
        System.out.println(map);

        Hashtable<String, String> table = new Hashtable<>();
       //table.put("null", null); // NPE => key & value should not be null
        System.out.println(table);
    }
}
