package com.tech.subash.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DeveloperUtil {
    private static List<String> fe = List.of("Flutter", "React");
    private static List<String> be =List.of("Java", "Spring Boot");
    public static List<Developer> getConstantDeveloper() {
        return LongStream.rangeClosed(1, 100).mapToObj(i -> Developer.builder().id(i)
                .name("name" + i)
                .email("email " + i)
                .programmingLanguage(i % 2 == 0 ? "Java" : "React")
                .role(i % 2 == 0 ? "BE" : "FE")
                .skills(i % 2 == 0 ? be : fe)
                .experienceYears(i % 2 == 0 ? 3 : 5).build()).collect(Collectors.toList());

    }
}
