package com.tech.subash.string.methods;

public class MutableStringAccess {
    public static void main(String[] args) {
        String name = "subash";  // -891546570
        System.out.println("initial " + name + " " +name.hashCode());
        name = name.concat("peranandas"); // diff hashCode -2077758279
        System.out.println("after concat "+ name +  " "+ name.hashCode());

        MutableString mutableString = new MutableString("subash.pernandas");
        System.out.println("mutablename  11 "+ mutableString.getName() + " "+  mutableString.hashCode());
        mutableString.name = "savari";
        System.out.println("mutablename 22 "+ mutableString.getName() + " "+  mutableString.hashCode());

        System.exit(0);

        StringBuilder sb = new StringBuilder("John");
        System.out.println(sb.hashCode());
        sb.replace(0, 4, "Mike");
        System.out.println(sb.hashCode()+ " "+ sb);


    }
}
