package com.tech.subash.pass.by.values;

class Student {
    String name;

    static void changeName(Student s) {
        s.name = "John";
    }

    static void changeObject(Student s) {
        s = new Student();
        s.name = "Bob";
    }
}

/*
What Java actually passed was the value of the reference (stu) — so inside the method,
both stu and s refer to the same object in memory, allowing changes to the object.
 */
class PassByValueUsingCustom {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.name = "Alice";
        System.out.println(stu.name);
        Student.changeObject(stu);
        System.out.println(stu.name);
    }
}
