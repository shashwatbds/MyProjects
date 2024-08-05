package org.example.blind75.slidingwindow.medium;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/***
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubStringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LongestSubStringWithoutRepeatingCharacters obj = new LongestSubStringWithoutRepeatingCharacters();
        System.out.println(obj.lengthOfLongestSubstringBruteForce("zxyzxyz"));
        System.out.println(obj.lengthOfLongestSubstringBruteForce("xxxx"));
        System.out.println(obj.lengthOfLongestSubstringBruteForce("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstringBruteForce("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstringBruteForce("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstringBruteForce(" "));

        System.out.println("\n\nEfficient Solution");
        System.out.println(obj.lengthOfLongestSubstringEfficient("zxyzxyz"));
        System.out.println(obj.lengthOfLongestSubstringEfficient("xxxx"));
        System.out.println(obj.lengthOfLongestSubstringEfficient("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstringEfficient("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstringEfficient("pwwkew"));
        System.out.println(obj.lengthOfLongestSubstringEfficient(" "));
    }

    /***
     * Uses Two pointer solution with sliding window technique. We will also use hashset to keep track of unique chars.
     * Time Complexity: O(n)
     * Space Complexity: O(k) - since we need a hashset. At any moment the highest number of spaces we will need is the length of longest substring found.
     * @param s : input string
     * @return size of longest substring with non-repeating chars
     */
    private int lengthOfLongestSubstringEfficient(String s) {

        //Edge cases below
        if(Objects.isNull(s) && s.length() != 0) {// We do not use is blank since it will not give length 1 for 1 space char.
            return 0;
        } else if(s.length() ==1) {
            return 1;
        }


        int left=0, right=0, ans = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length()) {
            char c = s.charAt(right);
            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            ans = Math.max(right-left+1, ans);
            right++;
        }
        return ans;
    }

    /**
     * For each char we will find the longest substring without non-repeating chars, we could use hashset for this
     *  as the add function returns false if the element already exists in the set.
     * Time Complexity: O(n^3): We will use two loops (n2) for finding a substring and another n loop to find if the current selected substring has a
     *                              repeating char or not.
     * Space Complexity:
     * @param s
     * @return
     */
    private int lengthOfLongestSubstringBruteForce(String s) {

        return 0;
    }

}
