package org.example.blind75.slidingwindow.medium;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
        System.out.println( 4 == obj.characterReplacement("XYYX", 4));
        System.out.println( 5 == obj.characterReplacement("AAABABB", 1));
        System.out.println( 4 == obj.characterReplacement("ABAB", 2));
        System.out.println( 4 == obj.characterReplacement("AABABBA", 1));
        System.out.println( 3 == obj.characterReplacement("BAAA", 0));
        System.out.println( 2 == obj.characterReplacement("ABAA", 0));
        System.out.println( 4 == obj.characterReplacement("ABBB", 2));
    }

    private int characterReplacement(String s, int k) {

        int left = 0, ans = 0, maxOccurance = 0;
        int[] occurrence = new int[26];
        for(int right=0; right< s.length(); right++) {
            maxOccurance = Math.max(maxOccurance, ++occurrence[s.charAt(right)-'A']);
            if(right - left + 1 - maxOccurance > k) {//if in current substring (from left pointer and right pointer, we can form a valid substring by replacing k number of chars
                occurrence[s.charAt(left)-'A']--;//because we need to reduce occurrence from left.
                left++;//increase left pointer
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}
