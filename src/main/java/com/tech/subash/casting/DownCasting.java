package com.tech.subash.casting;

   /*      Concept         | Description        | Safe?   | Requires Cast? |
        --------------- | --------------------- | ------- | -------------- |
        | Upcasting   | Subclass → Superclass | ✅ Safe  | ❌ No       |
        | Downcasting | Superclass → Subclass | ⚠ Risky | ✅ Yes       |
*/


public class DownCasting {
        public static void main(String[] args) {
            Animal a = new Dog();   // UPCASTING
            if(a instanceof  Dog) {
                System.out.println("a is instance of Dog");
                Dog d = (Dog) a;        // ✅ VALID DOWN CASTING
                d.bark();
            }

            Animal a2 = new Animal();
            if(a2 instanceof Dog) {
                Dog d2 = (Dog) a2; // Class Cast Exception
                d2.bark();
                d2.speak();
            } else {
                System.out.println("invalid object reference");
            }
        }
    }


