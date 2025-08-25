package com.tech.subash.java8;

import java.util.*;

public class TestObjectComparator implements Comparator<TestObject> {
    @Override
    public int compare(TestObject o1, TestObject o2) {
        return o2.name.compareTo(o1.name);// sorting
    }

    public static void main(String[] args) {
        TestObject testObject = new TestObject("subash.ps",31);
        TestObject testObject2 = new TestObject("subash.p",13);
        Set<TestObject> set = new HashSet<>();
        set.add(testObject2);
        set.add(testObject);
        System.out.println(set.size());
        List<TestObject> list = new ArrayList<>(set);
        System.out.println("list before sorting "+ list);
        Collections.sort(list, new TestObjectComparator());
        System.out.println(list);
    }
}
