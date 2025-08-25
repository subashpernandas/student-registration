package com.tech.subash.collections.internal.works;

import java.util.*;

/*
    Initial Capacity =  1 >> 4 = 0001 0000 => 16
    Max Capacity     = 1 >> 30 = 1,073,741,824
    Load Factor = 0.75 f;
    Terrify threashold = 8;
    unterrify threashold = 6;
    minterrify threashold = 64;

    | Map Type            | Ordered?            | Allows null keys/values?         | Thread-safe?   | Performance                | Backed by                 |
| ------------------- | ------------------- | -------------------------------- | -------------- | -------------------------------- | ------------------------- |
| `HashMap`           | ❌ Unordered         | ✅ One null key, many null values | ❌ No     | ⚡ Fast (O(1) access)             | Hash table                |
| `LinkedHashMap`     | ✅ Insertion order   | ✅ One null key, many null values | ❌ No     | ⚡ Slightly slower than `HashMap` | Hash table + Linked list  |
| `TreeMap`           | ✅ Sorted (by key)   | ❌ No null keys, ✅ null values    | ❌ No    | ⚠️ Slower (O(log n))             | Red-black tree            |
| `Hashtable`         | ❌ Unordered         | ❌ No null keys or values        | ✅ Yes (legacy) | ⚠️ Slower (synchronized)   | Hash table                |
| `ConcurrentHashMap` | ❌ Unordered         | ❌ No null keys or values      | ✅ Yes (modern) | ⚡ High concurrency        | Segment-based hash table  |
| `EnumMap`           | ✅ Ordered (by enum) | ❌ No null keys, ✅ null values   | ❌ No   | ⚡ Very fast                      | Array (internally)        |
| `WeakHashMap`       | ❌ Unordered         | ✅ One null key                   | ❌ No    | ⚠️ Depends                       | Weak references           |
| `IdentityHashMap`   | ❌ Unordered         | ✅ One null key               | ❌ No    | ⚠️ Rarely used                   | Reference equality (`==`) |
 */
public class HashMapInternalWorks {

    public static void main(String[] args) {

        int hash = "test".hashCode();
        System.out.println("hash " + hash);
        int index = hash & (16 - 1);
        System.out.println("index " + index);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("apple", 0);
        map.replace("apple", 1);             // Replace existing key's value
        int val = map.getOrDefault("cherry", 0);  // Get value or default 0
        System.out.println("val " + val);
        Integer a = map.remove("cherry");
        Integer b = map.get("B");
        boolean b0 = map.containsKey("B");
        boolean b1 = map.containsValue(1);

        Set<String> strings = map.keySet();
        Collection<Integer> values = map.values();
        // map.clear();

        map.putIfAbsent("cherry", 0);          // Put only if absent

     /*  [[ putIfAbsent ]] If "cherry" is not in the map, inserts "cherry" → 5.
          If "cherry" is already present, does nothing. */

        map.merge("apple", 3, (v1, v2) -> v1 + v2);

        map.computeIfPresent("apple", (k, v) -> v + 2);  // apple becomes 5
        map.computeIfPresent("cherry", (k, v) -> 1);
/*   [[ computeIfPresent ]]
       If "apple" is missing, it computes the value using the function and adds it.
       If "apple" is present, does nothing, but returns the existing value.
 */
        map.computeIfAbsent("A", value -> 2);// Now A=6
        System.out.println("Map " + map);

        Map<String, List<String>> groupMap = new HashMap<>();
        groupMap.computeIfAbsent("A", k -> new ArrayList<>()).add("item1");


    }
}
