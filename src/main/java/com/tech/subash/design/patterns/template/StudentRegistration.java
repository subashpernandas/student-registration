package com.tech.subash.design.patterns.template;

import java.util.HashMap;
import java.util.Map;

public abstract class StudentRegistration {
    static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("IT",32000);
        map.put("CSE",20000);
    }

    abstract String studentRegistration(Student student);

    int getDeptFees(String dept){
        return map.get(dept);
    }

    abstract void isFeesPaid(String regId, String studentName, int deptFee, boolean isPaid);

    public final void studentRegistrationProcedure(Student student) {
       String studentRegId = studentRegistration(student);
       int deptFee = getDeptFees(student.getDept());
       isFeesPaid(studentRegId, student.getName(),deptFee, student.isFeePaid());
    }
}
