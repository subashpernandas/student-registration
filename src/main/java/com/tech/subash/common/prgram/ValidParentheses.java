package com.tech.subash.common.prgram;

import java.util.*;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();  // LIFO
        for (char ch : s.toCharArray()) {
           if(ch == '('){
               stack.push(')');
           }else if(ch == '['){
               stack.push(']');
            } else if(ch == '{'){
               stack.push('}');
           } else if (stack.pop() != ch) {
               return false;
           }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String one = "([[{}]])";
        System.out.println(isValid(one));
    }
}
