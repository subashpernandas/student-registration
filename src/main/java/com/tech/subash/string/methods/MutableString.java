package com.tech.subash.string.methods;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

//@Data
@AllArgsConstructor
public class MutableString {
     String name;

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        MutableString mutableString = new MutableString("subash");
        MutableString mutableString1 = new MutableString("subash");
        System.out.println(mutableString.hashCode() + " "+ mutableString1.hashCode());

        Set<MutableString> mutableStrings = new HashSet<>();
        mutableStrings.add(mutableString1);
        mutableStrings.add(mutableString);
        System.out.println(mutableStrings.size());
    }
}
