package com.tech.subash.collections.internal.works;

import java.util.EnumMap;
import java.util.Map;

/*
    Null Keys = Not Allowed
    Null Values = Allowed
    Iteration = Follows Natural Order
    Thread Safety =  No (If you want need Collection.synchronizedMap())
    Faster Than => HashMap
    internal storage = Uses an array indexed by the enum's ordinal
 */

enum Days {
    MONDAY("task-1"),
    TUESDAY("task-2"),
    WEDNESDAY("task-3");

    final String task;
    Days(String task){
        this.task = task;
    }
}
public class EnumMapDemo {
    public static void main(String[] args) {
        EnumMap<Days, String> enumMap = new EnumMap<>(Days.class);
        enumMap.put(Days.TUESDAY, Days.TUESDAY.task);
        enumMap.put(Days.WEDNESDAY, Days.WEDNESDAY.task);
        enumMap.put(Days.MONDAY, null);
       // enumMap.put(null, Days.MONDAY.task); // Null Pointer Exception
        System.out.println(enumMap);

        for (Map.Entry<Days, String> daysStringEntry : enumMap.entrySet()) {
            System.out.println(daysStringEntry.getKey());
        }

        enumMap.entrySet().stream().forEach(kv -> System.out.println(kv.getKey() + " "+ kv.getValue()));
        enumMap.forEach((key,value) -> System.out.println(key + " "+ value));

    }
}
