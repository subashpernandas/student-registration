package com.tech.subash.common.prgram;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class InterviewQuestions {
    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = new HashMap<>();
        unsortedMap.put("Apple", 10);
        unsortedMap.put("Orange", 5);
        unsortedMap.put("Banana", 20);
        unsortedMap.put("Grape", 15);

        unsortedMap = unsortedMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e, e1) -> e1, TreeMap::new));
        System.out.println(unsortedMap);

        String s = "20";

        if (s instanceof String) {
            System.out.println(s);
        }


    }
}
