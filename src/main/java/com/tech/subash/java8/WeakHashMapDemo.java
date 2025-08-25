package com.tech.subash.java8;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) throws InterruptedException {
        Map<TestObject, String> weakMap = new WeakHashMap<>();

        TestObject key1 = new TestObject("subash.ps",31);  // Strong reference
        TestObject key2 = new TestObject("subash.sp",13);  // Will be made weak

        weakMap.put(key1, "Value 1");
        weakMap.put(key2, "Value 2");

        System.out.println("Before GC: " + weakMap);

        // Remove strong reference to key2
        key2 = null;

        // Encourage garbage collection
        System.gc();

        // Give GC a moment
        //Thread.sleep(1000);

        System.out.println("After GC: " + weakMap);
    }
}
