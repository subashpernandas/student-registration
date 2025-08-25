package com.tech.subash.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employ {
    String name;
    String empId;
    int age;
    int experience;
    Dept dept;
    Address address;

    @Data
    static class Dept {
        String deptName;
        List<String> skills;
        int salary;
    }

    @Data
    static class Address {
        String locality;
        String area;
        String state;
        String pinCode;
    }


    public static void main(String[] args) {
        Employ employ = new Employ();
        employ.setName("subash.ps");
        employ.setExperience(7);
        employ.setEmpId("MSIL-721");
        Employ.Dept dept1 = new Dept();
        dept1.setDeptName("Dev");
        dept1.setSkills(List.of("Java", "Spring Boot"));
        dept1.setSalary(125000);
        employ.setDept(dept1);
        Employ.Address address1 = new Address();
        address1.setArea("Keelkattzahi");
        address1.setLocality("St.Paul church");
        address1.setState("Tamil nadu");
        address1.setPinCode("600117");
        employ.setAddress(address1);

        Employ employ1 = new Employ();
        employ1.setName("monish.ps");
        employ1.setExperience(2);
        employ1.setEmpId("MSIL-1321");
        Employ.Dept dept2 = new Dept();
        dept2.setDeptName("Dev");
        dept2.setSkills(List.of("Java", "Spring Boot"));
        dept2.setSalary(25000);
        employ1.setDept(dept2);
        Employ.Address address2 = new Address();
        address2.setArea("Keelkattzahi");
        address2.setLocality("St.Paul church");
        address2.setState("Tamil nadu");
        address2.setPinCode("600117");
        employ1.setAddress(address1);

        Employ employ3 = new Employ();
        employ3.setName("ajith.ia");
        employ3.setExperience(3);
        employ3.setEmpId("MSIL-1021");
        Employ.Dept dept3 = new Dept();
        dept3.setDeptName("Banking");
        dept3.setSkills(List.of("Dally", "CSE"));
        dept3.setSalary(15000);
        employ3.setDept(dept3);
        Employ.Address address3 = new Address();
        address3.setArea("Km Kottai");
        address3.setLocality("St.Yovan church");
        address3.setState("Tamil nadu");
        address3.setPinCode("623603");
        employ3.setAddress(address3);
        List<Employ> employList = List.of(employ, employ1, employ3);

        //COLLECTORS.MAPPING
        Map<String, List<String>> collect = employList.stream().collect(Collectors.groupingBy(e -> e.getDept().getDeptName(),
                Collectors.mapping(Employ::getName, Collectors.toList())));
        System.out.println(collect);

        Map<String, Long> collect1 = employList.stream().collect(Collectors.groupingBy(e -> e.getDept().getDeptName(), Collectors.counting()));
        System.out.println(collect1);

        System.exit(0);


        Map<String, Set<String>> deptToSkills = employList.stream()
                .filter(Objects::nonNull).collect(Collectors.groupingBy(
                        e -> e.getDept().getDeptName(),
                        Collectors.flatMapping(e -> e.getDept().getSkills().stream(),
                                Collectors.toSet())
                ));
        System.out.println("Dept to Skills " + deptToSkills);


        Map<String, List<String>> deptToSkillsDistinct = employList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        e -> e.getDept().getDeptName(), // Group by dept name
                        Collectors.mapping(
                                e -> e.getDept().getSkills(), // Extract list of skills per employee
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        skillLists -> skillLists.stream()
                                                .flatMap(List::stream)
                                                .distinct()
                                                .collect(Collectors.toList())
                                )
                        )
                ));
        System.out.println("Dept to Skills " + deptToSkillsDistinct);

        Map<String, List<String>> deptToUniqueSkills = employList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        e -> e.getDept().getDeptName(),
                        Collectors.collectingAndThen(
                                Collectors.flatMapping(
                                        emp -> emp.getDept().getSkills().stream(),
                                        Collectors.toList()
                                ),
                                skillList -> skillList.stream()
                                        .distinct()
                                        .collect(Collectors.toList())
                        )
                ));

        System.out.println("Dept to Skills " + deptToUniqueSkills);

        System.exit(0);

        Map<String, Map<String, Integer>> resultS = employList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        e -> e.getDept().getDeptName(),
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(e -> e.getDept().getSalary())),
                                opt -> opt.map(e -> Map.of(e.getName(), e.getDept().getSalary()))
                                        .orElse(Collections.emptyMap())
                        )
                ));

        System.out.println(resultS);


        Map<String, Map<String, Integer>> result1 = employList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(
                        e -> e.getDept().getDeptName(),
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(e -> e.getDept().getSalary())),
                                opt -> {
                                    Map<String, Integer> map = new HashMap<>();
                                    opt.ifPresent(e -> map.put(e.getName(), e.getDept().getSalary()));
                                    return map;
                                }
                        )
                ));
        System.out.println(result1);


    }


}
