package com.tech.subash.java8.collectors;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
class Person {
    String name;
    String city;
    List<String> nicknames;

}

@Data
@AllArgsConstructor
class Author {
    String name;
    List<String> books;
}

public class CollectorsFlatMapping {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Alice", "New York", List.of("Al", "Lissy")),
                new Person("Bob", "New York", List.of("Bobby")),
                new Person("Charlie", "Chicago", List.of("Chuck", "Char"))
        );

        Map<String, Set<String>> nicknamesByCity = people.stream()
                .collect(Collectors.groupingBy(
                        Person::getCity,
                        Collectors.flatMapping(
                                person -> person.getNicknames().stream(),
                                Collectors.toSet()
                        )
                ));

        System.out.println(nicknamesByCity);


        List<Author> authors = List.of(
                new Author("Alice", List.of("A1", "A2")),
                new Author("Bob", List.of("B1")),
                new Author("Alice", List.of("A3"))
        );

        Map<String, List<String>> booksByAuthor = authors.stream()
                .collect(Collectors.groupingBy(
                        Author::getName,
                        Collectors.flatMapping(
                                author -> author.getBooks().stream(),
                                Collectors.toList()
                        )
                ));

        System.out.println(booksByAuthor);

        List<String> sentences = List.of(
                "Hello world",
                "Java is cool",
                "Streams are powerful"
        );

        List<String> allWords = sentences.stream()
                .collect(Collectors.flatMapping(
                        s -> Arrays.stream(s.split(" ")),
                        Collectors.toList()
                ));

        System.out.println(allWords);

    }
}
