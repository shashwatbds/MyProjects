package org.example.blind75.dp1.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        System.out.println(obj.wordBreak("leetcode", Arrays.asList("leet","code")));
        System.out.println(obj.wordBreak("applepenapple", Arrays.asList("apple","pen")));
        System.out.println(obj.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> wordSet = new HashSet<>(wordDict);

        for(int i=1; i<=s.length(); i++) {
            for(int j=i-1; j>=0; j--) {
                if(dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
