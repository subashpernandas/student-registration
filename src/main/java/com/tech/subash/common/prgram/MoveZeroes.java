package com.tech.subash.common.prgram;

import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
       int index = 0;

       for(int num : nums){
           if(num != 0){
               nums[index++] = num;
           }
       }
       while (index < nums.length){
           nums[index++] = 0;
       }
    }

    public static void main(String[] args) {
        int []a =  new int[] {1,0,3,2,0,5};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
