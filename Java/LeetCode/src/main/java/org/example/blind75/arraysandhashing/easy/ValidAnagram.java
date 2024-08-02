package org.example.blind75.arraysandhashing.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Uber Interview Question
 * */
public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();
        System.out.println("\nBrute Force Approach");
        System.out.println(obj.isAnagramBruteForce("anagram", "nagaram"));
        System.out.println(obj.isAnagramBruteForce("rat", "car"));
        System.out.println("\nSorting Approach");

        System.out.println(obj.isAnagramSorting("anagram", "nagaram"));
        System.out.println(obj.isAnagramSorting("rat", "car"));

        System.out.println("\nEfficient Approach");
        System.out.println(obj.isAnagramEfficient("anagram", "nagaram"));
        System.out.println(obj.isAnagramEfficient("rat", "car"));
    }

    /**
     * Time Complexity: O(n) - because we are only iterating the string through its size once and once we are iterating a array of constant size 26.
     * Space complexity is also O(26) which is constant.
     * */
    public boolean isAnagramEfficient(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];//Size 26 for each alphabet of english language. We can also use a HashMap for this which would be more efficient for large sized strings.
        for(int i=0; i<s.length();i++) {
            count[s.charAt(i) - 'a']--;//'a' equivalent int value is 97 and 'b' is 98 and so on, if the charAt(i) is a then it will update index 0 and so on.
            count[t.charAt(i) - 'a']++;
        }

        for(int i=0; i<26; i++) {
            if(count[i] != 0)
                return false;
        }
        return true;
    }
    /**
     * Time complexity - O(n2)
     * */
    public boolean isAnagramBruteForce(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(sMap.containsKey(s.charAt(i))) {
                int count = sMap.get(s.charAt(i));
                sMap.put(s.charAt(i), count+1);
            } else {
                sMap.put(s.charAt(i), 1);
            }
        }

        for(int i=0; i<t.length(); i++) {
            if(tMap.containsKey(t.charAt(i))) {
                int count = tMap.get(t.charAt(i));
                tMap.put(t.charAt(i), count+1);
            } else {
                tMap.put(t.charAt(i), 1);
            }
        }

        if(sMap.keySet().size() != tMap.keySet().size()) {
            return false;
        }

        Iterator<Character> iterator = sMap.keySet().iterator();;
        while(iterator.hasNext()) {
            Character c = iterator.next();
            if(sMap.get(c) != tMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Time complexity O(nlongn)
     * Space Complexity - O(n) - actually we create two more arrays of size n.
     * */
    public boolean isAnagramSorting(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for(int i=0; i< s.length(); i++) {
            if(sArr[i] != tArr[i])
                return false;
        }
        return true;
    }
}
