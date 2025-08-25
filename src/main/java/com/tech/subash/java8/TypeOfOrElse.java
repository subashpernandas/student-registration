package com.tech.subash.java8;

import java.util.NoSuchElementException;
import java.util.Optional;

public class TypeOfOrElse {
    public static void main(String[] args) throws Exception {
        Developer d = null;
        Optional<Developer> optional = Optional.ofNullable(d);
        System.out.println(optional.map(Developer::getName).orElse("Null"));
        System.out.println(optional.map(Developer::getName).orElseGet(() -> orElseGet()));
        System.out.println(optional.map(Developer::getName).orElseThrow(() -> orElseThrowException()));

    }

    public static String orElseGet() {
        return "Null";
    }

    public static Exception orElseThrowException() {
        return new NoSuchElementException();
    }
}
