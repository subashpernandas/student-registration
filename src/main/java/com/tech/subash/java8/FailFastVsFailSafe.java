package com.tech.subash.java8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailFastVsFailSafe {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("A", "B", "C"));
        Iterator<String> it = list.iterator();

        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("B")) {
                list.remove(s);
            }
        }
    }
}
