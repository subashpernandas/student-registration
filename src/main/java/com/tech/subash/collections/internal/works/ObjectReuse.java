package com.tech.subash.collections.internal.works;

public class ObjectReuse {
    public static void main(String[] args) {

        Developer developer = new Developer("subash",32);
        System.out.println("1 " + developer.hashCode() + " "+ developer);
        developer = validateDeveloper(developer);
        System.out.println("3 " + developer.hashCode() + " "+ developer);
    }

    public static Developer validateDeveloper(Developer developer){
        if(developer.age > 31){
            developer.setName("subash pernandas");
            developer.setAge(13);
            System.out.println("2 " + developer.hashCode() + " "+ developer);
            return  developer;
        }  return developer;
    }
}
