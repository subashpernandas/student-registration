package com.tech.subash.collections.internal.works;

import java.util.*;

public class IteratorVsListIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B","E", "D", "C"));
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            if (itr.next().equals("C")) {
                //list.add("E");  // CMException
                //list.remove("C");  // CMEexcetion
            }
        }
        System.out.println("Iterator "+ list);

        //System.exit(0);

        ListIterator<String> itr1 = list.listIterator();
        while (itr1.hasNext()) {
            String value = itr1.next();  // itr1.hasPrevious()
            if (value.equals("C")) {
                itr1.set("W"); // Add & then Set => illegalstateException
                itr1.add("E"); // Set & then Add => No Exception
                //list.remove("C");  // Accepted
            }
        }
        System.out.println("Iterator "+ list);
    }
}
