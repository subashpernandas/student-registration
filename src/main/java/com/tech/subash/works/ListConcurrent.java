package com.tech.subash.works;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListConcurrent {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        Iterator<String> itr = list.iterator();
       /* while (itr.hasNext()){
            String next = itr.next();
            if(next.equals("A")){ // No CME
                list.remove("B");
            }
        }*/

        while (itr.hasNext()){
            String next = itr.next();
            if(next.equals("B")){ // CME
                list.remove("B");
            }
        }
        System.out.println(list);
    }
}
