package com.tech.subash.design.patterns.abstraction.factory;

public class AbstractFactoryAccess {
    public static void main(String[] args) {
        CommonDeptFactory dept = new ItDeptFactory();
        dept.deptInstance().registerStudent("IT","Subash.PS");

        CommonDeptFactory dept2 = new CseDeptFactory();
        dept2.deptInstance().registerStudent("CSE","Ajith.IA");
    }
}
