package com.tech.subash.common.prgram;

public class ReverseString {
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            chars[left] = (char)(chars[left] + chars[right]);
            chars[right] = (char)(chars[left] - chars[right]);
            chars[left] = (char)(chars[left] - chars[right]);
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverse("ABC")); // Output: dapredoc
    }
}
