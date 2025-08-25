package com.tech.subash.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArray {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String itr = iterator.next();
            if (itr.equalsIgnoreCase("Two"))
                // list.remove("Two");  // Throws Concurrent Modification Exception in ArraayList
                //list.add("Three");
            list.remove("Two");
            list.set(0, "One+");
        }
        System.out.println("List after add "+ list);
    }
}

