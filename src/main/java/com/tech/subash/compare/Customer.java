package com.tech.subash.comparablevscomparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer  {
    private String name;
    private int age;

    private String dept;

    //@Override
    /*public int compareTo(Customer o) {
        //int deptCompare = Integer.compare(this.dept, o.dept); // compare dept first
        int deptCompare = this.dept.compareTo(o.dept);

        thi.dep
        if (deptCompare != 0) {
            return deptCompare;
        }
        return this.name.compareTo(o.name); // if dept is same, compare names
    }*/




    public static void main(String[] args) {
        Comparator<Customer> comparator = Comparator.comparing(Customer::getDept).thenComparing(Customer::getAge);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("subash",32,"IT"));
        customerList.add(new Customer("surya",22, "CSE"));
        customerList.add(new Customer("ajith",25,"IT"));
        System.out.println("Before "+customerList);
        ///customerList.sort(comparator);

        Comparator<Customer> comparator2 = (customer1, customer2) -> {
            int deptCompare = customer1.getDept().compareTo(customer2.getDept());
            if(deptCompare != 0){
                return  deptCompare;
            } else {
                return Integer.compare(customer1.getAge(),customer2.getAge());
            }
        };

        Collections.sort(customerList, comparator2);
        System.out.println("After Compa"+customerList);


    }


}
