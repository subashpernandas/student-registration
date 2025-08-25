package com.tech.subash.java8.functional;

import java.util.function.Supplier;

/*
   Stream.generate(Supplier<T>)
   Optional.orElseGet(Supplier<T>);
 */
public class SupplierAccess {
    public static void main(String[] args) {

        Supplier<String> supplier = () ->"subash.pernandas";
        System.out.println(supplier.get());

        Supplier<String> supplierMethodLambda = () -> getName();
        System.out.println(supplierMethodLambda.get());

        Supplier<String> supplierMethodReference = SupplierAccess::getName;
        System.out.println(supplierMethodReference.get());
    }

    public static String getName(){
        return "subash.pernandas";
    }
}
