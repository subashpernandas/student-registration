package com.tech.subash.collections.internal.works;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.*;

/*
   Initial Capacity = 11
   Load Factor = 0.75f;
   Null Keys => NOT ALLOWED
   Null Values => NOT ALLOWED
   Thread Safe
   Synchronized ( get(), put(), remove())
 */

@Data
@AllArgsConstructor
@ToString
class Employee {
    private int empId;

}

public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<Employee, String> hashtable = new Hashtable<>();
        hashtable.put(new Employee(10), "USA"); // 10 % 11 =  10
        hashtable.put(new Employee(200), "IND"); // 2
        hashtable.put(new Employee(100), "CA"); // 1
        hashtable.put(new Employee(50), "AUS"); // 6
        hashtable.put(new Employee(300), "NZ"); // 3
        hashtable.put(new Employee(56), "UK"); // 1
        hashtable.put(new Employee(36), "IND"); // 1

       /*for (Employee key : hashtable.keySet()) {
           if (key.getEmpId() == 100) {
               System.out.println(key + ": " + hashtable.get(key));
               hashtable.put(new Employee(96), "US");  // CMException
           }
       }*/

        List<Employee> keys = new ArrayList<>(hashtable.keySet());

        for (Employee key : keys) {
            if (key.getEmpId() == 100) {
                hashtable.put(new Employee(96), "US");  // ✅ Safe now
            }
        }
        System.out.println(hashtable);
       /* in 1st Index =>  100=CA , 56=UK
          Output has to be print Tob to Bottom , Right to Left
        {   Employee(empId=10)=USA,
            Employee(empId=50)=AUS,
            Employee(empId=300)=NZ,
            Employee(empId=200)=IND,
            Employee(empId=56)=UK, Employee(empId=100)=CA }
       */
    }
}
