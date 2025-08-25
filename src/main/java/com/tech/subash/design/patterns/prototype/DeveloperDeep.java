package com.tech.subash.design.patterns.prototype;

import lombok.ToString;

@ToString
public class DeveloperDeep implements Cloneable {
    int age; // Wont change
    private String name; // Wont change
    private Address address; // This one changes because of  shllow copy

    public DeveloperDeep(String name, Address address, int age) {
        this.name = name;
        this.address = address;
        this.age =  age;
    }

    @Override
    public DeveloperDeep clone() {
        try {
            DeveloperDeep cloned = (DeveloperDeep) super.clone();
            //cloned.address = address.clone(); // ✅ Deep copy
            cloned.address = new Address(this.address);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        Address address = new Address("New York");
        DeveloperDeep originalObject = new DeveloperDeep("Alice", address,31);
        DeveloperDeep clonedObject = originalObject.clone();

        originalObject.age = 21;

        clonedObject.address.setCity("San Francisco");

        System.out.println("Original: " + originalObject);
        System.out.println("Cloned  : " + clonedObject);
    }
}
