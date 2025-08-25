package com.tech.subash.common.prgram;

import java.util.Arrays;

public class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // 1. Prefix product pass (left to right)
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 2. Suffix product pass (right to left)
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int a[] = new int[] {5,2,3,4}; // [24, 12, 8, 6]
        System.out.println(Arrays.toString(productExceptSelf(a)));
    }
}
