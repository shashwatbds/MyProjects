package org.example.blind75.slidingwindow.hard;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println("BANC".equals(obj.minWindow("ADOBECODEBANC","ABC")));
        System.out.println("a".equals(obj.minWindow("a","a")));
        System.out.println("".equals(obj.minWindow("a","aa")));
        System.out.println("YXAZ".equals(obj.minWindow("OUZODYXAZV","XYZ")));
        System.out.println("xyz".equals(obj.minWindow("xyz","xyz")));
        System.out.println("".equals(obj.minWindow("x","xy")));
    }

    /**
     * Brute Force: We start creating every possible substring using the chars of t and then we cn find the minimum length option for this.
     * Time Complexity: O(n^3)
     *
     * Efficient: Sliding window technique with two pointers.
     * Time Complexity: O(m+n) where m and n are lengths of input strings
     * Space Complexity: O(m+n)
     *
     * Best approach:
     * */
    private String minWindow(String s, String t) {

        if (s.length() < t.length()) return "";

        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE;

        for (char c : t.toCharArray()) map[c]++;

        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) count--;

            while (count == 0) {
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }

                if (map[s.charAt(start++)]++ == 0) count++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}