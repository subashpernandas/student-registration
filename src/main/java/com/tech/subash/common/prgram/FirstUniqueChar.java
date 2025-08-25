package com.tech.subash.common.prgram;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {
    public static char firstNonRepeatingChar(String str) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for(char c: str.toCharArray()){
            countMap.put( c, countMap.getOrDefault(c, 0) + 1);
        }

        for(Map.Entry<Character,Integer> entries : countMap.entrySet()){
            if(entries.getValue() == 1){
                return  entries.getKey();
            }
        }

        throw new RuntimeException("No unique character found");
    }

    public static void main(String[] args) {
        String input = "swiss";
        System.out.println(firstNonRepeatingChar(input));  // Output: w
    }
}
