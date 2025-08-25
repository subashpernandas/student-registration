package com.tech.subash.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    //@Autowired
    private final Staff staff;

   /* public void setStaff(Staff staff){
        this.staff = staff
    }*/

    public Student(Staff staff){
        this.staff = staff;
        System.out.println("student called");
    }
}
