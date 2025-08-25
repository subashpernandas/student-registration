package com.tech.subash.design.patterns.adapter;

public class DeptAdapter implements  Dept {

    private CseDept cseDept;

    private ItDept itDept;

    public DeptAdapter(String dept){
        switch (dept){
            case "IT":
                itDept = new ItDept();
                break;
            case "CSE":
                cseDept =  new CseDept();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    @Override
    public void registerStudentDetails(String dept, String name) {
        switch (dept){
            case "IT":
                itDept.studentRegistrationForIT(dept, name);
                break;
            case "CSE":
                cseDept.studentRegistrationForCSE(dept, name);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
