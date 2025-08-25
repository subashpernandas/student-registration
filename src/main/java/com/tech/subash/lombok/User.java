package com.tech.subash.lombok;

import lombok.*;

//@Value  // AllArgsConstructor + Getter Equal to Immutable Class => All
@With
@Getter
@RequiredArgsConstructor
public class User {
     final String name;
     final int age;


    /* what @With behind scene
    public User withName(String name) {
        return new User(name, this.age);
    }*/
}
