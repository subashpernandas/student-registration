package com.tech.subash.java8;

import java.util.Optional;

public class MapClassification {

    public static void main(String[] args) {
        Developer developer = null;
        Optional<Developer> optional = Optional.ofNullable(developer);
        System.out.println(optional.map(Developer::getId).orElse(1L));

        Employee employee = null;//Employee.builder().build();
        employee.setId(2L);
        employee.setAge(31);
        employee.setName("subash.ps");
        employee.setEmail("subashpernandas@gmail.com");
        Employee.Department department = null;//Employee.Department.builder().build();

      /*  department.setName("IT");
        department.setCode("IT-001");
        department.setFaculty("selva Daniel");*/
        employee.setDepartment(null);

        Optional<Employee> optionalEmployee = Optional.ofNullable(employee);
        String code = optionalEmployee.map(e -> {
                    System.out.println("dept " + e.getDepartment());
                    return e.getDepartment();
                }
        ).map(e -> {
            System.out.println("code " + e.getCode());
            return e.getCode();
        }).orElse("NULL");
        System.out.println(code);

    }
}
