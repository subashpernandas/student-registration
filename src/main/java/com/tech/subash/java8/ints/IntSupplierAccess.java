package com.tech.subash.java8.ints;

import java.util.function.*;

public class IntSupplierAccess {
    public static void main(String[] args) {
        IntSupplier intSupplier = () -> 16;
        System.out.println(intSupplier.getAsInt());

        LongSupplier longSupplier = () -> 16L;
        System.out.println(longSupplier.getAsLong());

        DoubleSupplier doubleSupplier = () -> 16.0;
        System.out.println(doubleSupplier.getAsDouble());

        IntConsumer intConsumer = (value) -> System.out.println(value);
        intConsumer.accept(21);

        LongConsumer longConsumer = (value) -> System.out.println(value);
        longConsumer.accept(21L);

        IntPredicate intPredicate = (value) -> value % 2 == 0;
        System.out.println(intPredicate.test(21));

        LongPredicate longPredicate = (value) -> value % 2 == 0;
        System.out.println(longPredicate.test(21L));

        DoublePredicate doublePredicate = (value) -> value % 2 == 0;
        System.out.println(doublePredicate.test(21.0));

        IntFunction<String> intFunction = (value) -> String.valueOf(value);
        System.out.println(intFunction.apply(21));

        ToIntFunction<String> stringToIntFunction = s -> s.length();
        System.out.println(stringToIntFunction.applyAsInt("Hello"));

        ToDoubleFunction<String> stringToDoubleFunction = s -> s.length();
        System.out.println(stringToDoubleFunction.applyAsDouble("Hello"));

        ToLongFunction<String> stringToLongFunction = s -> s.length();
        System.out.println(stringToLongFunction.applyAsLong("Hello"));

        IntUnaryOperator intUnaryOperator = (value) -> value * value;
        System.out.println(intUnaryOperator.applyAsInt(3));

        IntBinaryOperator intBinaryOperator = (value, value2) -> value + value2;
        System.out.println(intBinaryOperator.applyAsInt(2,3));
    }
}
