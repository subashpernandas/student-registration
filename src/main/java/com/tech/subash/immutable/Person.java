package com.tech.subash.immutable;

public final class Person {
    private final String name;
    private final int age;
    private final Address address;  // mutable object

    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = new Address(address); // defensive copy
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return new Address(address); // defensive copy
    }
}
