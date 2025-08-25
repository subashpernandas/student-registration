package com.tech.subash.collections.internal.works;

import java.util.LinkedList;

public class LinkedListInternalWorks {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(0,40);
        list.addFirst(50);
        System.out.println(list);
        list.remove(2);

        System.out.println(list.size());
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(list.size());


    }
}
