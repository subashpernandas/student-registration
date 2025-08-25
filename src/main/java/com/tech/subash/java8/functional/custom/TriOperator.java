package com.tech.subash.java8.functional.custom;

import org.apache.commons.lang3.function.TriFunction;

import java.util.function.BiFunction;

@FunctionalInterface
public interface TriOperator <T> extends TriFunction<T,T,T,T> {
}
