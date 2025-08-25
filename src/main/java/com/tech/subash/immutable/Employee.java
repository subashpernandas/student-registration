package com.tech.subash.immutable;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ToString
public final class Employee {
    private final String name;
    private final List<String> skills;

    public Employee(String name, List<String> skills) {
        this.name = name;
        this.skills = new ArrayList<>(skills); // Defensive copy
    }
    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        return new ArrayList<>(skills); // Return copy
    }

    public static void main(String[] args) {
        Employee employee = new Employee("subash", new ArrayList<>(List.of("cricket")));
        System.out.println("Before Employee " +employee);
        employee.getSkills().set(0, "BasketBall");
        System.out.println("After Employee "+ employee);

    }
}
