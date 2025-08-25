package com.tech.subash.design.patterns.adapter;

public class AdapterAccess {
    public static void main(String[] args) {
       DeptAdapter itDeptAdpater = new DeptAdapter("IT");
       itDeptAdpater.registerStudentDetails("IT","SUBASH.PS");

       DeptAdapter csDeptAdpater = new DeptAdapter("CSE");
       csDeptAdpater.registerStudentDetails("CSE","AJITH.IA");
    }
}
