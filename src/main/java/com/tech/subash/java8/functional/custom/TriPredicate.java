package com.tech.subash.java8.functional.custom;

@FunctionalInterface
public interface TriPredicate <T,U,V> {
    boolean test(T t, U u, V v);
}
