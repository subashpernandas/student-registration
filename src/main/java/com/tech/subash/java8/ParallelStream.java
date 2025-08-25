package com.tech.subash.java8;

import java.util.List;

public class ParallelStream {

    public static void main(String[] args) {
        List<Developer> listOfDeveloper = new DeveloperUtil().getConstantDeveloper();
        listOfDeveloper.parallelStream().forEachOrdered(dev -> {
            System.out.println("developer "+ dev);
        });

        listOfDeveloper.parallelStream().forEach(dev -> {
            System.out.println("developer "+ dev);
        });

    }


}
