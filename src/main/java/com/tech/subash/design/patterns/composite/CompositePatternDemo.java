package com.tech.subash.design.patterns.composite;

import com.tech.subash.java8.CopyOnWriteArray;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class CompositePatternDemo {
    public static void main(String[] args) {
        // Leaf nodes
        Student student1 = new Student("student1",31);
        Student student2 = new Student("student2",24);
        Student student3 = new Student("student3",34);

        // Composite nodes
        Department computer = new Department("computer");
        computer.addMember(student1);
        computer.addMember(student2);
       // computer.removeMember(student1);

        Department it = new Department("it");
        it.addMember(student3);

        // Displaying details
        computer.showDetails();
        it.showDetails();
    }
}