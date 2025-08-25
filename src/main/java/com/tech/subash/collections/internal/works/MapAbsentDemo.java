package com.tech.subash.collections.internal.works;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapAbsentDemo {
    public static void main(String[] args) {

        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("apple", 0);

        // ComputeIfAbsent => return as value => Safe even no value is there it doesn't throw NPE
        // [ If Key exists It Doesn't anything ]
        // [ If Key unexists It add new entry ]
        Integer apple = map.computeIfAbsent("apple", value -> 1);

        // PutIfAbsent => return as value =>
        // Never try to return value
        // [ If Key exists It Doesn't anything ]
        // [ If Key unexists It add new entry ]
        Integer apple1 = map.putIfAbsent("apple2", 20);
        System.out.println("entry value" + apple1);

        // This value will be computed only if "banana" is not in the map
        map.computeIfAbsent("apple", value -> createValue(2));

        // ComputeIfPresent
        map.computeIfPresent("apple", (key,value) -> value + 3);
        System.out.println(map);

        // Compute
        map.compute("apple", (key,value) -> value == null ? 10 : value + 10);
        System.out.println(map);
        map.compute("apple3", (key,value) -> value == null ? 10 : value + 10);
        System.out.println(map);
        map.compute("apple3", (key,value) -> null); // => This one remove from Map
        System.out.println(map);

        // Replace If Keys is Present and Values is Equal to exists then only Update
        map.replace("apple", 13, 30);
        System.out.println(map);
        map.replace("apple", 50);
        System.out.println(map);

        // Replace All
        map.replaceAll((key,value) -> value + 5);
        System.out.println(map);

        //map.replace("apple", null); // Accept
        //System.out.println(map);
        map.computeIfPresent("apple", (key,value) -> null);
        System.out.println(map);

    }

    public static Integer createValue(Integer value) {
        System.out.println("Computing value for " + value);
        return value * value;
    }
}
