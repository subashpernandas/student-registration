package com.tech.subash.design.patterns.factory;

public class ItDept implements  Dept{
    @Override
    public void registerStudent(String deptName, String studentName) {
        System.out.println("Dept Name "+ deptName + " Student Name " + studentName);
    }
}
