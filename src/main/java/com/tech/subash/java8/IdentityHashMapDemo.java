package com.tech.subash.java8;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put(new String("A"), "1");
        map.put(new String("A"), "2");

        System.out.println(map.size()); // RETURN 1

        Map<String, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(new String("A"), "1");
        identityHashMap.put(new String("A"), "2");
        System.out.println(identityHashMap.size()); // RETURN 2

        EnumMap<Day, String> enumMap = new EnumMap<>(Day.class);
        enumMap.put(Day.MON, Day.MON.getDay());
        enumMap.put(Day.TUE, Day.TUE.getDay());
        System.out.println(enumMap);
    }

    enum Day {
        MON("mon"), TUE("tue"), WED("wed");
        private String day;

        Day(String day){
            this.day = day;
        }

        public String getDay(){
            return  day;
        }

    }

}
