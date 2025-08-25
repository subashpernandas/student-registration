package com.tech.subash.common.prgram;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        boolean b = wordBreak("leetcode", List.of("leet", "code"));
        //boolean b2 = wordBreak("applepenapple", List.of("apple", "pen"));
        System.out.println(b );
       // System.out.println(b2);
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // s = leetcode,
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                System.out.println("substing "+ s.substring(j, i));
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further for this i
                }
            }
        }

        return dp[s.length()];
    }
}


