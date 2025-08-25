package com.tech.subash.solid.principle.open.closed.principle;

public class CseDeptRegistration  implements DeptRegistration {
    @Override
    public String studentRegistration() {
        return "75000 For CSE";
    }
}
