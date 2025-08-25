package com.tech.subash.polymorphism.overloading;

import java.time.LocalDate;

public class DateUtilForOverLoading {

    public static LocalDate addDays(){
        return  LocalDate.now();
    }

    public static LocalDate addDays(LocalDate localDate,int plusDays){
        return localDate.plusDays(plusDays);
    }

    public  static  LocalDate addDays(int plusDays, int month){
        return LocalDate.now().plusDays(2).plusMonths(month);
    }

    public static void main(String[] args) {
        LocalDate localDate = DateUtilForOverLoading.addDays();
        System.out.println("local Date "+ localDate);
        LocalDate plus2Days = addDays(localDate, 2);
        System.out.println("local Date "+ plus2Days);

    }
}
