package com.tech.subash.java8.collectors.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    String name;
    int age;

    String country;
    String city;
}
