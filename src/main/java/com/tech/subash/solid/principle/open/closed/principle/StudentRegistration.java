package com.tech.subash.solid.principle.open.closed.principle;

public class StudentRegistration {
    public static String studentRegistration(String dept) {
        String deptFees = "20000";
        switch (dept.toUpperCase()) {
            case "CSE" -> deptFees = deptFees.concat(" For CSE");
            case "IT" -> deptFees = deptFees.concat(" 1000 For IT");
            default -> throw new IllegalArgumentException("Invalid Dept");
        }
        return deptFees;
    }

    public static void main(String[] args) {
        System.out.println(StudentRegistration.studentRegistration("it"));
    }
}
