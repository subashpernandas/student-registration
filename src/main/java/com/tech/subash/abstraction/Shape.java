package com.tech.subash.abstraction;

// Q: Can you instantiate an abstract class in Java? If not, how can you use it in practice?
public abstract class Shape {
    abstract  void draw();

    void printInfo() {
        System.out.println("Print Details");
    }
}
