package com.tech.subash.java8;

import java.util.*;

public class EqualsAndHashCode {
    // Rules For a.equals(b) Then a.hashCode() == b.hashCode() must be true
    // If a.hashCode() == b.hashCode() has true,  a.equals(b) may be true or may not be
    public static void main(String[] args) {
        String s = new String("test");
        String s1 = new String("test");

        System.out.println(s.hashCode() + " "+ s1.hashCode()); // 3556498 3556498

        TestObject testObject = new TestObject("subash.ps",31);
        TestObject testObject2 = new TestObject("subash.ps",13);
        Set<TestObject> set = new HashSet<>();
        set.add(testObject2);
        set.add(testObject);
        System.out.println(set.size());
        List<TestObject> list = new ArrayList<>(set);
        System.out.println("list before sorting "+ list);
        Collections.sort(list);
        System.out.println(list);



    }
}
