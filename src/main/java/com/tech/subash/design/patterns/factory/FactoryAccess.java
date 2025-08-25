package com.tech.subash.design.patterns.factory;

public class FactoryAccess {
    public static void main(String[] args) {
        Dept dept =  DeptFactory.deptFactory("IT");
        dept.registerStudent("IT","Subash.PS");

        Dept dept2 = DeptFactory.deptFactory("CSE");
        dept2.registerStudent("CSE","Ajith.IA");
    }
}
