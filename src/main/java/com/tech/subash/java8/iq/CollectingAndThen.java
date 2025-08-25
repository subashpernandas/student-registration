package com.tech.subash.java8.iq;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    String name;
    String department;

}

public class CollectingAndThen {

    public static void main(String[] args) {
        List<String> list = List.of("AB", "BCDD", "C");
        int max = list.stream().mapToInt(String::length).sum();
        System.out.println(list.stream().max(Comparator.comparingInt(String::length)));

        List<String> unmodifiable = list.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
        System.out.println(unmodifiable);
        //  unmodifiable.add("D");  Throws UnsupportedOperationException

        Map<String, Integer> nameLengthMap = Stream.of("Alice", "Bob", "Charlie")
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                                Function.identity(),       // key = name
                                String::length             // value = length
                        ), Collections::unmodifiableMap
                ));

        System.out.println(nameLengthMap); // Output: {Alice=5, Bob=3, Charlie=7}

        String longest = Stream.of("Java", "Python", "C++")
                .collect(Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(String::length)),
                        Optional::get // unwrap from Optional
                ));

        System.out.println(longest);

        Object count = Stream.of("Tom", "Tim", "Tina", "Bob")
                .filter(name -> name.startsWith("T"))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), List::size
                ));

        System.out.println((int) count);

        List<String> names = List.of("Alice", "Adam", "Bob", "Brian", "Charlie");

        Map<Character, List<String>> grouped = names.stream().collect(
                Collectors.groupingBy(
                        name -> name.charAt(0),                            // group by first letter
                        Collectors.collectingAndThen(
                                Collectors.toList(),                           // collect to list
                                Collections::unmodifiableList                  // make list unmodifiable
                        )
                )
        );
        System.out.println(grouped);

        Map<Integer, Integer> lengthCounts = Stream.of("Tom", "Tim", "Anna", "Eve", "Alan")
                .collect(Collectors.groupingBy(
                        String::length,                                   // group by string length
                        Collectors.collectingAndThen(
                                Collectors.counting(),                        // count per group
                                Long::intValue                                // convert Long to Integer
                        )
                ));

        System.out.println(lengthCounts);

        List<Employee> employees = List.of(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "IT"),
                new Employee("Diana", "HR")
        );

        Map<String, Set<String>> deptToNames = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.mapping(Employee::getName, Collectors.toSet()),
                                Collections::unmodifiableSet
                        )
                )
        );

        System.out.println(deptToNames);
    }
}
