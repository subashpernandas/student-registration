package com.tech.subash.collections.internal.works;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyListNoConcurrent {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("B");
        list.add("A");

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String ne = itr.next();
            if (ne.equals("B")) {
                list.remove("A");
            }
        }


    }
}
