package com.tech.subash.circular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/*
  1) add properties=  true
  2) in anyOneConstructorInjection => set @Lazy
  3) one ConstructorInjection & another setterInjection
  4) Refactor Design => create an Interface.
 */
@Component
public class Staff {

   // @Autowired
    private final Student student;

   /* @Autowired
    public void setStudent(Student student){
        this.student = student;
    }*/

    public Staff(@Lazy  Student student){
        this.student = student;
        System.out.println("student called");
    }
}
