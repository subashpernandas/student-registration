package com.tech.subash.java8;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Objects;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TestObject  implements Comparable<TestObject> {
    protected String name;
    protected int age;


    public  boolean equals(Object o){
        if (this == o) return  true;
        if(!(o instanceof TestObject)) return  false;
        TestObject testObject = (TestObject) o;
        return age== testObject.age && name.equals(testObject.name);
    }

    public int hashCode(){
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(TestObject o) {
        //return this.age - this.age;  // ascedning order
        return  o.age - this.age; // descending order
    }
}
