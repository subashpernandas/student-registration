package com.tech.subash.immutable.breaking;

import java.lang.reflect.Field;

final class Student {
    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class BreakImmutableUsingReflection {
    public static void main(String[] args) throws Exception {
        Student s = new Student("John");
        System.out.println("Before: " + s.getName());

        Field field = Student.class.getDeclaredField("name");
        field.setAccessible(true);
        field.set(s, "Hacked");

        System.out.println("After: " + s.getName());
    }
}
