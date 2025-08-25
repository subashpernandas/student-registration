package com.tech.subash.exception;

import java.util.*;

public class UnCheckedException {
    private static final int[] array = new int[]{1, 3, 2, 5};
    private static final List<String> list = new ArrayList<>(Arrays.asList("1", "3", "2"));

    public static void main(String[] args) {
        nullPointerExeption(null);
        System.out.println("next method call");
        arrayIndexOutOfBound(6);
        System.out.println("next method call");
        arithmeticException(); // 10/0
        System.out.println("next method call");
        unSupportedOperationException();  // For List.of() and Arrays.asList() We cant Add but Remove
        System.out.println("next method call");
        concurrentModificationException();
        System.out.println("next method call");
        numberFormatException("a");
        System.out.println("next method call");
        classCastException();
    }


    public static void nullPointerExeption(String s) {
        try {
            s.toLowerCase();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void arrayIndexOutOfBound(int index) {
        try {
            int valueEqualToIndex = array[index];
            System.out.println(valueEqualToIndex);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    private static void arithmeticException() {
        try {
            int i = 10 / 0; // Arithmetic Exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void unSupportedOperationException() {
        try {
            list.add("5");
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Un Supported Exception " + e.printStackTrace(););
        }
    }

    public static void concurrentModificationException() {
        Iterator <String> iterator = list.iterator(); // remove() => OK but Add() Error
       try {
           while (iterator.hasNext()) {
               String next = iterator.next();
               if (next.equals("3")) {
                   list.add("3");
               }
           }
       } catch (Exception e){
           e.printStackTrace();
       }
    }

    public static void numberFormatException(String s){
     try {
         Integer i = Integer.parseInt(s);
         System.out.println(i);
     } catch(Exception e){
         e.printStackTrace();
     }
    }

    private static void classCastException() {
        Object o = new Object();
        UnCheckedException unCheckedException =  (UnCheckedException) o;
    }
}
