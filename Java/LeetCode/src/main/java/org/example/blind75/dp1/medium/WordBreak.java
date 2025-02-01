package org.example.blind75.dp1.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        System.out.println(obj.wordBreak("espn", Arrays.asList("e","sp","n")));
        System.out.println(obj.wordBreak("leetcode", Arrays.asList("leet","code")));
        System.out.println(obj.wordBreak("applepenapple", Arrays.asList("apple","pen")));
        System.out.println(obj.wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> wordSet = new HashSet<>(wordDict);

        for(int i=1; i<=s.length(); i++) {//Iterate string per chars
            for(int j=i-1; j>=0; j--) {//This is to check if the whole string exist or not, since at each index
                // we will check if the existing word break exists in dp
                // and the rest of the string is present in dict.
                if(dp[j] && wordSet.contains(s.substring(j, i))) {//dp[j] - this value would be word break of substring or 0 to j.
                    // and substring j to i is checking if the substring inside word_dict
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
