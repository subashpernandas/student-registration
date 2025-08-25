package com.tech.subash.design.patterns.abstraction.factory;

public class CseDeptFactory extends CommonDeptFactory {
    @Override
    public Dept deptInstance() {
        return new CseDept();
    }
}
