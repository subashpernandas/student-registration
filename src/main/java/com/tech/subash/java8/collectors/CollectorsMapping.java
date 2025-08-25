package com.tech.subash.java8.collectors;


import com.tech.subash.java8.collectors.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsMapping {
    public static void main(String[] args) {
        List<com.tech.subash.java8.collectors.model.Person> people = List.of(
                new com.tech.subash.java8.collectors.model.Person("Alice", 30,"USA", "New York"),
                new com.tech.subash.java8.collectors.model.Person("Bob", 31,"USA", "Chicago"),
                new com.tech.subash.java8.collectors.model.Person("Charlie",25, "USA", "New York"),
                new com.tech.subash.java8.collectors.model.Person("David", 25, "UK", "London")
        );

        Map<Integer, List<String>> namesByAge = people.stream()
                .collect(Collectors.groupingBy(
                        com.tech.subash.java8.collectors.model.Person::getAge,
                        Collectors.mapping(com.tech.subash.java8.collectors.model.Person::getName, Collectors.toList())
                ));

        System.out.println(namesByAge);

        Map<String, Set<String>> citiesByCountry = people.stream()
                .collect(Collectors.groupingBy(
                        com.tech.subash.java8.collectors.model.Person::getCountry,
                        Collectors.mapping(com.tech.subash.java8.collectors.model.Person::getCity, Collectors.toSet())
                ));

        System.out.println(citiesByCountry);

        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "HR"),
                new Employee("Charlie", "IT")
        );

        Map<String, List<String>> initialsByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(e -> e.getName().substring(0, 1), Collectors.toList())
                ));
        System.out.println(initialsByDept);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        Map<Integer, List<Integer>> squaresByRemainder = numbers.stream()
                .collect(Collectors.groupingBy(
                        n -> n % 3,
                        Collectors.mapping(n -> n * n, Collectors.toList())
                ));

        System.out.println(squaresByRemainder);
    }
}
