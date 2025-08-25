package com.tech.subash.copies.deep.mute;

import lombok.ToString;

@ToString
class Person {
    MutableString name;
    Address address;

    // Constructor
    public Person(MutableString name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow Copy
    public Person(Person other) {
        this.name = other.name;
        this.address = other.address;
    }


    // Deep Copy
    public Person(Person other, boolean deepCopy) {
        this.name = new MutableString(other.name.value); // separate object
        this.address = new Address(other.address.city);   // separate object
    }
}