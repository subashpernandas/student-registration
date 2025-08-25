package com.tech.subash.concurren.collection;

import java.util.concurrent.ConcurrentSkipListMap;

public class ThreadSafeMap {

    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> skipMap = new ConcurrentSkipListMap<>();
        skipMap.put(10, "Ten");
        skipMap.put(5, "Five");
        skipMap.put(20, "Twenty");

        System.out.println(skipMap); // Output: {5=Five, 10=Ten, 20=Twenty}

    }
}
