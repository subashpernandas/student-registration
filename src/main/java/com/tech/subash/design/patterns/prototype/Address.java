package com.tech.subash.design.patterns.prototype;

import lombok.ToString;

@ToString
public class Address {//implements Cloneable {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public Address(Address address) {
        this.city = address.city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

//    @Override
//    public Address clone() {
//        try {
//            return (Address) super.clone(); // Shallow is fine because no deeper fields
//        } catch (CloneNotSupportedException e) {
//            throw new AssertionError();
//        }
//    }
}
