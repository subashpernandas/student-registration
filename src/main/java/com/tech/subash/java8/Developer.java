package com.tech.subash.java8;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Developer {

    private Long id;
    private String name;
    private String email;
    private String programmingLanguage;
    private int experienceYears;

    private String role;
    private List<String> skills;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("startTime time "+ startTime);
        List<Developer> listOfDeveloper = DeveloperUtil.getConstantDeveloper();
        listOfDeveloper.parallelStream().forEach( developer -> {
            System.out.println("developer Object Thread Name " + Thread.currentThread().getName() + developer);
        });
        long endTime = System.currentTimeMillis();
        System.out.println("end Time "+ endTime);
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " ms");
    }




}
