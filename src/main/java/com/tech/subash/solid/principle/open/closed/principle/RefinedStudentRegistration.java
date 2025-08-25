package com.tech.subash.solid.principle.open.closed.principle;

public class RefinedStudentRegistration {
    DeptRegistration deptRegistration = null;

    RefinedStudentRegistration(DeptRegistration deptRegistration) {
        this.deptRegistration = deptRegistration;
    }
    public String studentRegistrationDetail() {
        return deptRegistration.studentRegistration();
    }

    public static void main(String[] args) {

        RefinedStudentRegistration refinedStudentRegistration = new RefinedStudentRegistration(new CseDeptRegistration());
    }
}
