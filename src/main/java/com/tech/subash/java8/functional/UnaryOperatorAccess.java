package com.tech.subash.java8.functional;

import com.tech.subash.java8.functional.custom.TriOperator;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;
/*
   Unary Operator::
   -------------------
   It extends from Function Interface, and we can use apply(name);
   But here input and output can same type only.

   Binary Operator::
   ----------------
   It extends from BiFunction Interface, and we can use apply(name);
   But here input and output can same type only.

 */
public class UnaryOperatorAccess {
    public static void main(String[] args) {

        Function<String, Integer> function = (value) -> Integer.parseInt(value);
        System.out.println(function.apply("25"));

        UnaryOperator<String> unaryOperator = (name) -> name.toUpperCase();
        System.out.println(unaryOperator.apply("subash.ps"));

        UnaryOperator<Double> unaryOperator1 = (value) -> Math.pow(value, 3);
        System.out.println(unaryOperator1.apply(2.0)); // 2^3

        BinaryOperator<Integer> binaryOperator =  (value, value1) -> value + value1;
        System.out.println(binaryOperator.apply(16,21));

        TriOperator<Integer> triOperator =  (value, value1, value2) -> value + value1 + value2;
        System.out.println(triOperator.apply(16,21,25));


    }
}
