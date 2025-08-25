package com.tech.subash.immutable;

public class ExampleOfViolation {
    public static void main(String[] args) {
        Person p = new Person("John", 30, new Address("Chennai"));
        Address a = p.getAddress();  // oops, direct reference to internal state!
        a.setCity("Mumbai");         // changes internal state of Person

        //Normal Constructor and Getter it returns Mumbai
        //When it makes Depensive Copy then it will return Delhi Only
        System.out.println(p.getAddress().getCity());  // prints "Chennai"

    }
}
