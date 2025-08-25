package com.tech.subash.copies.deep.mute;

import lombok.ToString;

@ToString
class Address {
    String city;

    public Address(String city) {
        this.city = city;
    }
}