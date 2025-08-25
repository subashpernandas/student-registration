package com.tech.subash.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A","B"));
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            String element = iterator.next();
            if(element.equalsIgnoreCase("A")){
                list.remove("A");
            }
        }

       // list.removeIf(l -> l.equalsIgnoreCase("C"));
        System.out.println(list);
    }
}
