package com.tech.subash.interview;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private String name;
    private int age;
    private List<String> phoneNo;
    private Dept dept;
    private Address address;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Dept {
        private String position;
        private int salary;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Address {
        private String city;
        private String state;
        private String country;
    }

    public static void main(String[] args) {
        Student student1 = new Student("Alice", 22, Arrays.asList("9344768445", "9445192245"),
                new Dept("Engineer", 75000),
                new Address("New York", "NY", "USA"));

        Student student2 = new Student("Bob", 24, Arrays.asList("9344768446", "9445192246"),
                new Dept("Analyst", 68000),
                new Address("Los Angeles", "CA", "USA"));

        Student student3 = new Student("Charlie", 21, Arrays.asList("9344768447", "9445192247"),
                new Dept("Intern", 25000),
                new Address("Chicago", "IL", "USA"));

        Student student4 = new Student("Alice", 22, Arrays.asList("9344768445", "9445192245"),
                new Dept("Engineer", 25000),
                new Address("New York", "NY", "USA"));

        List<Student> students = Arrays.asList(student1, student2, student3, student4);
        // students.forEach(System.out::println);

        Map<String, Student> maxSalaryByDept = students.stream().collect(Collectors.groupingBy(
                stu -> stu.getDept().getPosition(),
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingInt(st -> st.getDept().getSalary())),
                        Optional::get)));
        maxSalaryByDept.forEach((key, value) -> System.out.println(key + " " + value));

        // Find the Engineer lives in the USA and Get Salary more than 50000

        Predicate<Student> countryPredicate = (student) -> student.getAddress().getCountry().equals("USA");
        Predicate<Student> salaryPredicate = (student) -> student.getDept().getSalary() > 50000;
        Predicate<Student> professionPredicate = (student) -> student.getDept().getPosition().equalsIgnoreCase("Engineer");

        students.stream().filter(countryPredicate.and(salaryPredicate).and(professionPredicate)).forEach(System.out::println);

        // Find all the MobileNumber Whose coming from New York
        Predicate<Student> cityPredicate = (student) -> student.getAddress().getCity().equals("New York");
        List<String> listOfMobileNumberWhoseBelongFromNewYork = students.stream().filter(cityPredicate).flatMap(stu -> stu.getPhoneNo().parallelStream()).toList();
        System.out.println(listOfMobileNumberWhoseBelongFromNewYork);

        List<String> listOfMobileNumberWhoseBelongFromNewYorkAlterNate = students.stream().filter(cityPredicate).collect(Collectors.flatMapping(student -> student.getPhoneNo().parallelStream(), Collectors.toList()));
        // System.out.println(listOfMobileNumberWhoseBelongFromNewYorkAlterNate);

        //Whose working as Intern eligible for the salaryIncrement from current ctc + 10%; => Map<name, updatedSalary)
        Predicate<Student> professionPredicateForIntern = (student) -> student.getDept().getPosition().equalsIgnoreCase("Intern");
        Map<String, Integer> interEmployeesAndTheirUpgradeSalary = students.stream().filter(professionPredicateForIntern).collect(
                Collectors.toMap(Student::getName, stu -> stu.getDept().getSalary() + (stu.getDept().getSalary() * 10 / 100)));
        System.out.println(interEmployeesAndTheirUpgradeSalary);

        // Find Max Salary in Each Dept Map<Dept,Object>


        System.out.println("\n");
        Map<String, Student> collect = students.stream().collect(Collectors.toMap(stu -> stu.getDept().getPosition(), stu -> stu,
                (s1, s2) -> s1.getDept().getSalary() >= s2.getDept().getSalary() ? s1 : s2));
        collect.forEach((key, value) -> System.out.println(key + " " + value));

        Map<String, Student> maxSalaryByDeptOne = students.stream()
                .collect(Collectors.toMap(
                        stu -> stu.getDept().getPosition(),
                        stu -> stu,
                        BinaryOperator.maxBy(Comparator.comparingInt(st -> st.getDept().getSalary()))
                ));

    }

}
