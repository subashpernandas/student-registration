package com.tech.subash.java8;


import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        System.out.println(getValues());
        System.out.println(optimizeGetValues());
    }

    public static String getValues() {
        Developer developer = null;
        Optional<Developer> optional = Optional.ofNullable(developer);
        if (optional.isPresent()) {
            return optional.get().getName();
        } else {
            return "Null";
        }
    }

    public static String optimizeGetValues() {
        Developer developer = null;
        Optional<Developer> optional = Optional.ofNullable(developer);
        return optional.map(Developer::getName).orElse("Null");
    }
}
