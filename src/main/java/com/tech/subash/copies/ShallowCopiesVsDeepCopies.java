package com.tech.subash.copies;

import java.util.ArrayList;
import java.util.List;

/*

original.age is copied by value → ✅ no link between original and shallowCopy for age
original.name is a String (immutable, copied by reference, safe)
original.hobbies is a List<String> (mutable, copied by reference → ⚠️ shared)

 */
class Person implements Cloneable {
    String name;
    List<String> hobbies;
    int age;

    Person(String name, List<String> hobbies, int age) {
        this.name = name;
        this.hobbies = hobbies;
        this.age = age;
    }

    // Shallow copy
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // Deep copy
    protected Person deepClone() {
        List<String> clonedHobbies = new ArrayList<>(this.hobbies);
        return new Person(this.name, clonedHobbies, this.age);
    }

    @Override
    public String toString() {
        return name + ": " +hobbies + ":" + age;
    }
}

public class ShallowCopiesVsDeepCopies {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Reading");
        hobbies.add("Swimming");

        Person originalObject = new Person("Alice", hobbies,31);
        Person shallowObject = (Person) originalObject.clone();      // Shallow copy
        Person deepObject = originalObject.deepClone();           // Deep copy
        System.out.println(originalObject.hashCode() + " "+ shallowObject.hashCode() + " "+ deepObject.hashCode());
        //                  849460928                         580024961                     2027961269

        originalObject.name = "Subash.PS";
        originalObject.age = 32;
        originalObject.hobbies.add("Cycling");
        deepObject.hobbies.add("Dancing");

        System.out.println(originalObject);  // Subash.PS : [Reading, Swimming, Cycling] : 32
        System.out.println(shallowObject);  // Alice: [Reading, Swimming, Cycling] : 31
        System.out.println(deepObject);  // Alice: [Reading, Swimming, Dancing] : 31
    }
}
