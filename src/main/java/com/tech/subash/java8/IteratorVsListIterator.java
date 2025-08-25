package com.tech.subash.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorVsListIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("A", "B", "C"));
        Iterator<String> it = list.iterator();
        // ADD ELEMENTS NOT ABLE TO SUPPORT
        // ONLY FORWARD DIRECTION
        // hasNext(), next(), remove()
        // APPLICABLE ALL COLLECTION
        while(it.hasNext()) {
            String s = it.next();
            if(s.equals("B")) {
                it.remove();  // Safe removal
               // list.add("D"); // CONCURRENT MODIFICATION EXCEPTION
            }
        }
        //list.forEach(System.out::println); // A, C
        System.out.println("List after iterator "+ list);

        ListIterator<String> listIt = list.listIterator();
        // ADD ELEMENTS  ABLE TO SUPPORT
        // FORWARD & BACKWARD DIRECTION
        // hasNext(), next(), hasPrevious(), previous(), remove(), add(), set()
        // APPLICABLE ONLY ARRAYLIST AND LINKED LIST
        while(listIt.hasNext()) {
            String s = listIt.next();
            if(s.equals("C")) {
                listIt.set("Between"); // Modify element
                listIt.add("Beta");    // Add new element
            }
        }
        //list.forEach(System.out::println); // A, between, Beta
        System.out.println("List after List iterator "+ list);

    }
}
