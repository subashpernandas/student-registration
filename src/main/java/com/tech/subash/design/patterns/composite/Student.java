package com.tech.subash.design.patterns.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

// Leaf
@Data
@AllArgsConstructor
@NoArgsConstructor
class Student implements Participant {
    private String name;
    private int age;

    public void showDetails() {
        System.out.print(name+ " "+age);
    }
}