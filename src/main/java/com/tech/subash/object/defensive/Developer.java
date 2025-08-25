package com.tech.subash.object.defensive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developer {
    private String name;
    private int age;
    private Package packages;

    public Package getPackages() {
        return new Package(packages);
    }


    @Data
    @AllArgsConstructor
    static class Package {
        private int lpa;
        private int noOfOffers;

        public Package(Package other){
            this.lpa = other.lpa;
            this.noOfOffers = other.noOfOffers;
        }
    }

    public static void main(String[] args) {

        Developer developer = new Developer("subash.ps",31, new Package(21,4));
        Package package1 = developer.getPackages(); // It will give new copy
        package1.setNoOfOffers(5);
        developer.setName("pernandas");

        System.out.println("Original " + developer.getName()+" "+ developer.getPackages().getNoOfOffers());
        System.out.println("Updated " +  developer.getName()+" "+ package1.getNoOfOffers());
    }
}
