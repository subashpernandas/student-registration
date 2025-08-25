package com.tech.subash.string.methods;

/*
   Objects on the Heap are distinct, even if the content is same
   Reference check (==) in SCP  => Return true
                           Heap => Usually different False
   usage 1:
   Strings are used as Keys in HashMap
   The hashCode() of a String is cached after creation.
   If the String were mutable, the hashcode could change, breaking hash based collection.
   usage 2:
   Strings are used in heavily in Multithread Environment
   String is Thread-Safe, Immutable Objects are automatically Thread-Safe.
 */
public class StringComparison {
    public static void main(String[] args) {
        String s = "subash.ps";  // store in string constant pool, is same is exists point to the same.
        String s1 = "subash.ps";
        System.out.println(s.equals(s1));  // true
        System.out.println(s == s1); // true

        String s3 = new String("subash.ps");  // store object at runtime in Heap
        System.out.println(s.equals(s3));  // true
        System.out.println(s == s3);  // false

        String s4 = new String("subash.ps");
        String s5 = new String("subash.ps");
        System.out.println(s4.equals(s5));  // true
        System.out.println(s4 == s5);  // false

        String s6 = "subash.ps";
        s6 = s6.concat(".pernandas");  // String Heap => StringConcatHelper.simpleConcat
        System.out.println("concat " + s6);  // From Heap

        String s7 = "subash.ps.pernandas"; // SCP
        System.out.println(s6 == s7);  // False Bcoz One From SCP and another one From Heap

        //    Before concat: s6 ---> "Subash" (SCP)
        //    After concat:  s6 ---> "Subash pernandas" (Heap)
        //    Old "Subash" still exists in SCP
        //    Any string modification method (concat(), replace(), toUpperCase(), etc.)
        //    creates a new object.



    }
}
