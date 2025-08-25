package com.tech.subash.iq;

import com.tech.subash.enums.EmployeeTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class Student {
    private String name;
    private int age;
    private String dept;



    public static void main(String[] args) {


        EnumMap<EmployeeTypeEnum, String> enumMap = new EnumMap(EmployeeTypeEnum.class);
        System.out.println(enumMap.put(EmployeeTypeEnum.PERMANENT, "subash")); //null
        System.out.println(enumMap.put(EmployeeTypeEnum.PERMANENT, "subash"));  // subash
        System.exit(0);

        Student student = new Student("subash", 21, "It");
        Student student2 = new Student("ajith", 21, "It");
        Student student4 = new Student("monish", 11, "CSE");
        Student student3 = new Student("kishore", 8, "It");
        List<Student> list = new ArrayList<>(Arrays.asList(student, student4, student3, student2));

        String excludeName = "ajith";
        Comparator<Student> comparing = Comparator.comparing((Student s) -> !s.getName().equals(excludeName))
                .thenComparing((s) -> s.getName());
        Collections.sort(list, comparing);
        System.out.println(list);

    }
}
