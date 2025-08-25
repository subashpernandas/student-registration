package com.tech.subash.design.patterns.template;

public class TemplateAccess {
    public static void main(String[] args) {

        StudentRegistration studentRegistration = new CSEDeptRegistration();
        studentRegistration.studentRegistrationProcedure(new Student("aryan.ps",17,"CSE",true));
    }
}
