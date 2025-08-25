package com.tech.subash.abstraction;

/*
No, you cannot instantiate an abstract class directly.
However, you can use it by:
Creating a subclass that extends the abstract class and implements its abstract methods.
Using anonymous inner classes to provide implementation on the fly.
 */

public class ShapeAccess {
    public static void main(String[] args) {
        Shape shape = new Shape() {
            @Override
            void draw() {
                System.out.println("Draw");
            }
        };
        shape.draw();
        shape.printInfo();
    }
}
