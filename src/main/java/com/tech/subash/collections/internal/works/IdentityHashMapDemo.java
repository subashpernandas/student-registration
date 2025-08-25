package com.tech.subash.collections.internal.works;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
class Person {
    String name;

    public String getName() {
        return name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return this.getName().equals(person.getName());
    }

    public int hashCode() {
        return Objects.hash(name);
    }
}

public class IdentityHashMapDemo {  // Even it's Equals and HashCode was Override doesn't care.

    public static void main(String[] args) {

        Map<Person, String> identityHashMap = new IdentityHashMap<>();

        Person p1 = new Person("Alice");
        Person p2 = new Person("Alice");  // Different object, same content
        Person p3 =  null;
        Person p4 =  null;


        System.out.println(p1.hashCode() + " " + p2.hashCode());

        identityHashMap.put(p1, "Person 1");
        identityHashMap.put(p2, "Person 2");
        identityHashMap.put(p3, "Person 3");
        identityHashMap.put(p4, "Person 3");
        System.out.println("Map size: " + identityHashMap.size());
        System.exit(0);

        Map<Person, String> hashMap = new java.util.HashMap<>();
        hashMap.put(p1, "Person 1");
        hashMap.put(p2, "Person 2");
        System.out.println("HashMap size: " + hashMap.size());
    }
}