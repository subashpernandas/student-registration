package com.tech.subash.java8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    private Long id;
    private String name;
    private int age;
    private String email;
    private Double salary;
    private Department department;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Department {
        private String code;
        private String name;
        private String faculty;
    }


}
