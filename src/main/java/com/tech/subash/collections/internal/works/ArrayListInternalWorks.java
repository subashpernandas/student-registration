package com.tech.subash.collections.internal.works;

import java.util.ArrayList;
import java.util.LinkedList;

/*  Shifting is need in between any insertion/ deletion from developer.
    For Search (get) => O(1)
    For insertion & deletion same at the end of index => O(1)
        specified index => O(n)
    For Search O(n) iterate all
    Default Size = 10

 */
public class ArrayListInternalWorks {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(); // It just Create a new array
        arrayList.add("subash"); // here only it assign with 10 elements
        arrayList.remove("");
        arrayList.get(2);
        //Once it 10 elements added then 11th it create a new Array and copy the old one into new array
        // with 10 >> 1 => 10+10/2 = 15
    }
}
