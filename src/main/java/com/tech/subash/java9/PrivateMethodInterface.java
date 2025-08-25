package com.tech.subash.java9;

public interface PrivateMethodInterface {

    void registerStudentDetails();

    default void computeClass() {
        // System.out.println("for cse");
        commonLogic();
    }

    default void automationLabs() {
        //System.out.println("for it");
        commonLogic();
    }

    private void commonLogic() {
        System.out.println("if anyone want they will join");
    }
}
