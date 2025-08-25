package com.tech.subash.design.patterns.prototype;

import lombok.ToString;

@ToString
public class DeveloperShallow implements Cloneable {
    int age; // Won't change
    private String name; // Won't change
    private Address address; // Change because of Shallow cloning.

    public DeveloperShallow(String name, Address address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public DeveloperShallow clone() {
        try {
            return (DeveloperShallow) super.clone(); // ⚠️ Shallow copy
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        Address address = new Address("New York");
        DeveloperShallow originalObject = new DeveloperShallow("Alice", address,31);
        DeveloperShallow clonedObject = originalObject.clone();
        System.out.println("hashCode "+ originalObject.hashCode() + " "+ clonedObject.hashCode());
        //hashCode                      849460928                        580024961
        clonedObject.address.setCity("San Francisco");
        originalObject.age =23;

        System.out.println("Original: " + originalObject);
        System.out.println("Cloned  : " + clonedObject);
    }
}
