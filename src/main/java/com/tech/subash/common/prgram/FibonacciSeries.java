package com.tech.subash.common.prgram;

import java.util.Arrays;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(finbonacci(10));  // 1,2,3,upt 9
    }

    public static int finbonacci(int n){
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
