package com.tech.subash.design.patterns.factory;

public class DeptFactory {

    public static Dept deptFactory(String dept){
        return switch (dept) {
            case "IT" -> new ItDept();
            case "CSE" -> new CseDept();
            default -> null;
        };
    }
}
