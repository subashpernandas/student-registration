package com.tech.subash.method.reference;

import java.util.function.Function;

public class BoundVsUnBound {
    public static void main(String[] args) {
        //Meaning: “Call this method on this particular object.”
        //The instance (obj) is fixed ahead of time.
        //The functional interface parameter (String) becomes the method argument.
        //The mc instance is already known, so no extra object is needed at runtime.

        BoundVsUnBound mc = new BoundVsUnBound();
        Function<String, String> f = mc::nameConversion2;
        f.apply("java"); // calls mc.nameConversion2("java")


        //Meaning: “Call this method on whatever instance is given as the first parameter.”
        //The instance will be provided at runtime.
        //The String instance comes from the apply argument.
        //String::toUpperCase says: take the first argument, and call toUpperCase() on it.


        Function<String, String> unBoundinstance = String::toUpperCase;
        f.apply("java"); // calls "java".toUpperCase()
    }

    private String nameConversion2(String s) {
        return s.toUpperCase();
    }
}
