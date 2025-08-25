package com.tech.subash.method.reference;


import java.util.List;
import java.util.function.Function;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        // METHOD REFERENCE
        Function<String, String> nameConversion = MethodReferenceDemo::nameConversion;

        String apply = nameConversion.apply("subash.p");
        System.out.println(apply);
        List<String> list = List.of("name", "subash");
        list = list.stream().map(MethodReferenceDemo::nameConversion).toList();
        System.out.println(list);

        //USING LAMBDA
        Function<String, String> lamda = (name) -> nameConversion(name);
        String apply1 = lamda.apply("subash.ps");
        System.out.println(apply1);

        Function<String, String> s = String::toUpperCase;


    }

    public static String nameConversion(String name) {
        return name.toUpperCase();
    }


    public  String nameConversion2(String name) {
        return name.toUpperCase();
    }
}
