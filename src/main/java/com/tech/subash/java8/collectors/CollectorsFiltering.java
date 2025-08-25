package com.tech.subash.java8.collectors;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.tech.subash.java8.collectors.model.Person;

public class CollectorsFiltering {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Alice",32, "US","New York"),
                new Person("Bob", 25,"US","New York"),
                new Person("Charlie", 23,"Canada","Chicago"),
                new Person("David", 35, "US","Chicago")
        );

        Map<String, List<String>> over30ByCity = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getCity,
                        Collectors.filtering(
                                p -> p.getAge() > 30,
                                Collectors.mapping(Person::getName, Collectors.toList())
                        )
                ));

        System.out.println(over30ByCity);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Integer, Long> evenCountByMod3 = numbers.stream()
                .collect(Collectors.groupingBy(
                        n -> n % 3,
                        Collectors.filtering(
                                n -> n % 2 == 0,
                                Collectors.counting()
                        )
                ));

        System.out.println(evenCountByMod3);

        List<String> words = List.of("Apple", "ant", "Banana", "Berry", "carrot", "Dog");

        Map<Integer, List<String>> capitalWordsByLength = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.filtering(
                                w -> Character.isUpperCase(w.charAt(0)),
                                Collectors.toList()
                        )
                ));

        System.out.println(capitalWordsByLength);
    }
}
