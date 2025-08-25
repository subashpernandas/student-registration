package com.tech.subash.string.methods;

public class HashCodeVsSystem {
    public static void main(String[] args) {
        // By Default (in Object class), it returns a value based on the object’s memory reference,
        // but many classes override it (like String, Integer, or your custom classes)
        // to reflect logical equality instead of the actual memory reference.
        String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println(s1.hashCode());                // same: 99162322 (based on content)
        System.out.println(s2.hashCode());                // same: 99162322

        // Always returns the hash code based on the actual memory reference of the object,
        // ignoring any override of hashCode().
        //Useful when you want the true identity of the object rather than its logical content.
        System.out.println(System.identityHashCode(s1)); // different, based on memory reference
        System.out.println(System.identityHashCode(s2)); // different, based on memory reference

    }
}
