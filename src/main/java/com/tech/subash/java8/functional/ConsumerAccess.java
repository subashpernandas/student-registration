package com.tech.subash.java8.functional;

import com.tech.subash.java8.functional.custom.TriConsumer;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/*
   forEach();
   forEachOrdered();
   peek();
   Optional.ifPresent();
   Map.forEach();

 */
public class ConsumerAccess {
    public static void main(String[] args) {

        Consumer<String> consumerLamda = (name) -> System.out.println(name.toUpperCase());
        consumerLamda.accept("subash.ps");

        Consumer<String> consumerLamdaMethod = (name) -> printName(name);
        consumerLamdaMethod.accept("subash.ps");

        Consumer<String> consumerLamdaMethodRef = ConsumerAccess::printName;
        consumerLamdaMethodRef.accept("subash.ps");

        BiConsumer<String, String> consumerBiRef = ConsumerAccess::printNameForBiConsume;
        consumerBiRef.accept("subash.ps", "pernandas");

        TriConsumer<String, String, String> consumerTriRef = ConsumerAccess::printNameForTriConsume;
        consumerTriRef.accept("subash.ps", "pernandas", "31");

        Map<String, Integer> map = Map.of("A", 1, "B", 2);
        map.forEach((key, value) -> System.out.println(key + ": " + value));

    }
    public static void printName(String name){
        System.out.println(name.toUpperCase());
    }

    public static void printNameForBiConsume(String name, String fatherName){
        System.out.println(name.toUpperCase() + " "+ fatherName.toUpperCase());
    }

    public static void printNameForTriConsume(String name, String fatherName, String age){
        System.out.println(name.toUpperCase() + " "+ fatherName.toUpperCase() + " "+ age);
    }




}
