package com.tech.subash.common.prgram;

public class ReverseInteger {
    public static int reverse(int number) {
        int result = 0;
        while (number != 0){
            int remainder =  number % 10;
            result = result * 10 + remainder;
            number = number / 10;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(reverse(1092));
    }
}
