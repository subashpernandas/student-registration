package com.tech.subash.collections.internal.works;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReUseArrayList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        list = Arrays.asList("X", "Y", "Z");
        System.out.println(list); // [X, Y, Z]
        //list.add("V"); // UnSupported Operation.
        //System.out.println(list);

        // Reassign with a new mutable list
        list = new ArrayList<>(Arrays.asList("X", "Y", "Z"));
        list.add("W");  // Now it's mutable
        System.out.println(list); // [X, Y, Z, W]

        // ✅ 3. Update values in place (if you don’t want to reassign)
        list.clear();
        list.addAll(Arrays.asList("X", "Y", "Z"));
        list.add("C");
        System.out.println(list); // [X, Y, Z, C]

        // ✅ 4. Replace specific elements (in-place update)
        list.set(0, "P");  // Replace first element
    }
}
