package com.tech.subash.common.prgram;

public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;

        for (int i = 3; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
        // For 3 steps 1+1+1 , 2 step + 1 step , 1step first + 2step
        // For 4 Step 1+1+1+1, 2+1+1, 1+1+2, 1+2+1 = 4
    }
}
