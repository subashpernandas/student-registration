package com.tech.subash.collections.internal.works;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyListConcurrent {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");


        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String currentelement = itr.next();
            if (currentelement.equals("B")) {
                System.out.println("current element "+ currentelement);
                list.remove("B"); // Concurrent
            }
            System.out.println(list);
            /*if (ne.equals("B")) {
                list.remove("A"); // Concurrent
            }*/

            /*if (ne.equals("A")) {
                list.remove("A"); // No Concurrent
            }*/

            /*if (ne.equals("A")) {
                list.remove("B"); // No Concurrent
            }*/


        }


    }
}
