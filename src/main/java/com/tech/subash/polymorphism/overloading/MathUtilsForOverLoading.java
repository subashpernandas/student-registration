package com.tech.subash.polymorphism.overloading;

/*
Multiple methods with same name but different parameters
Method Overloading
Decision made at Compile Time
Use case Same method name, different inputs
 */

public class MathUtilsForOverLoading {
    int addSum(int a, int b) {
        return a + b;
    }

    int addSum(int a, int b , int c){
        return a+b+c;
    }

    int addSum(int ... a){
      if(a.length < 3){
          throw new IllegalArgumentException("At least 3 must be passes");
      }
      int sum = 0;
      for (int s : a){
          sum = s + sum;
      } return  sum;
    }

    public static void main(String[] args) {
        MathUtilsForOverLoading mathUtils = new MathUtilsForOverLoading();
        System.out.println(mathUtils.addSum(new int[]{2,3,4,5,7,9}));
    }
}
