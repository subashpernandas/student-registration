package com.tech.subash.concurren.collection;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListVsriteArrayList {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        //List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");

        for (String item : list) {
            list.add("C");  // Safe — snapshot of list is used // For list throws Concurrent Modification
            System.out.println(item);
        }
    }
}
