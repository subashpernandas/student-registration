package com.tech.subash.common.prgram;

import java.util.*;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);   // Return index
        }
        return new int[] {};  // no solution
    }

    public static void main(String[] args) {
        int[] result = twoSum(new int[]{1,3,5,7,9}, 6);
        System.out.println(Arrays.toString(result));
    }
}
