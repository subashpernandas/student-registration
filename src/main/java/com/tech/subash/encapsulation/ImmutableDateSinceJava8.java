package com.tech.subash.encapsulation;

import java.time.LocalDate;
import java.util.Date;

public class ImmutableDateSinceJava8 {
    public static void main(String[] args) {
        Date date = new Date(); // current Date
        System.out.println("Date "+ date);
        date.setDate(2); // current Date + 2 days
        System.out.println("Date "+ date);

        LocalDate localDate = LocalDate.now();
        System.out.println("Local Date in Java 8 " + localDate);
        LocalDate plus2Days = localDate.plusDays(2);
        System.out.println("Local Date in Java 8 " + plus2Days);


    }
}
