package com.tech.subash.design.patterns.abstraction.factory;

public class ItDeptFactory extends CommonDeptFactory {
    @Override
    public Dept deptInstance() {
        return new ItDept();
    }
}
