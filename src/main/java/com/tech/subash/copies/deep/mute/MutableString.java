package com.tech.subash.copies.deep.mute;

import lombok.ToString;

@ToString
class MutableString {
    String value;

    public MutableString(String value) {
        this.value = value;
    }
}