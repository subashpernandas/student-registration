package com.tech.subash.java8.iq;

import com.tech.subash.java8.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IQ1 {
    public static void main(String[] args) {
        List<Employee> employees = List.of();
        Map<String, List<Employee>> result = employees.stream()
                .filter(e -> e.getAge() > 30)
                .collect(Collectors.groupingBy(
                        e-> e.getDepartment().getName(),
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                                        .collect(Collectors.toList())
                        )
                ));



    }
}
