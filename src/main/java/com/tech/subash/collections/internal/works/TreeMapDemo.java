package com.tech.subash.collections.internal.works;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/*    Null Keys = Not Allowed
      Null Values = Allowed.
      Sorting Based On Keys,
      Not Synchronized & Not Thread-safe

 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());  // Custom Comparator
        treeMap.put("apple", 1);
        treeMap.put("banana", 2);
        treeMap.put("cherry", 3);
        treeMap.put("date", 4);

        // treeMap.put(null,null);  NPE
        System.out.println("Tree Map Order Based On Key  " + treeMap);
        System.out.println("First Key: " + treeMap.firstKey());
        System.out.println("Last Key: " + treeMap.lastKey());
        System.out.println("Higher than 'banana': " + treeMap.higherKey("banana")); 
        System.out.println("Lower than 'banana': " + treeMap.lowerKey("banana"));

        System.exit(0);


        TreeMap<Integer, String> tm = new TreeMap<>();
        tm.put(10, "Ten");
        tm.put(20, "Twenty");
        tm.put(30, "Thirty");

        System.out.println("First Key: " + tm.firstKey());   // 10
        System.out.println("Last Key: " + tm.lastKey());     // 30
        System.out.println("Higher than 20: " + tm.higherKey(20)); // 30
        System.out.println("Lower than 20: " + tm.lowerKey(20));   // 10

    }
}
