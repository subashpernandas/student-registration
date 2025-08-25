package com.tech.subash.design.patterns.abstraction.factory;

public class CseDept implements Dept {
    @Override
    public void registerStudent(String deptName, String studentName) {
        System.out.println("Dept Name "+ deptName + " Student Name " + studentName);
    }
}
