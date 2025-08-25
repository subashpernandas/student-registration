package com.tech.subash.deep.dive;

import java.lang.reflect.Field;
import java.util.*;

public class ModCountExample {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");

        // Get modCount from AbstractList
        Field modCountField = AbstractList.class.getDeclaredField("modCount");
        modCountField.setAccessible(true);

        int modCount = (int) modCountField.get(list);
        System.out.println("modCount = " + modCount);  // Example: 2
    }
}
