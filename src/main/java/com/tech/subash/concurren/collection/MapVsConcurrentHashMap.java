package com.tech.subash.concurren.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapVsConcurrentHashMap {
    public static void main(String[] args) {
       ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        //Map<String, Integer> map = new HashMap<>();

        map.put("one", 1);
        map.put("two", 2);

        for(String keys: map.keySet()){
            if(keys.equals("one")){
                map.put("three", 3);  // For HashMap Concurrent Modification
            }
        }
        System.out.println(map);
    }
}
