package org.example.blind75.arraysandhashing.medium;

import java.util.*;

/**
 * Amazon, Netflix, Microsoft
 * */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
//        System.out.println(obj.groupAnagramsSorting(new String[]{"eat","tea","tan","ate","nat","bat"}));
//        System.out.println(obj.groupAnagramsSorting(new String[]{"a"}));
//        System.out.println(obj.groupAnagramsSorting(new String[]{""}));
//        System.out.println("\nEfficient Code");
        System.out.println(obj.groupAnagramsEfficient(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(obj.groupAnagramsEfficient(new String[]{"a"}));
        System.out.println(obj.groupAnagramsEfficient(new String[]{""}));
    }

    /**
     * Technique
     **/
    public List<List<String>> groupAnagramsEfficient(String[] strs) {

        // 1. Base case
        if(strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> ansMap = new HashMap<>();
        int[] count = new int[26];
        for(String s: strs) {//3 steps for each string
            Arrays.fill(count, 0);
            for(char c: s.toCharArray()) {
                count[c - 'a']++;//1. toggle value of string to 1 in int array for each char
            }
            StringBuilder sb = new StringBuilder("");
            for(int i=0; i<26; i++) {//2. create key for adding in map.
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList<>());
            }
            ansMap.get(key).add(s);
        }
        return new ArrayList<>(ansMap.values());
    }

    /**
     * Sorting - you also have to maintain the index, so you would create a map, sort the string within list,
     * then you can compare them with one another. you have to make sure you don't access the list again with item which
     * have already been identified as part of an anagram.
     * Time complexity O(nlogn)
     * Time Complexity - O(n*klongk) * k - where k is length of longest string and n is number of strings in the strs array.
     * Space Complexity: O(k*n) - where k is length of longest string.
     */
    public List<List<String>> groupAnagramsSorting(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i< strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String sortedStr = new String(c);
            if(map.containsKey(sortedStr)) {// this means we already have a anagram string of this in the result.
                result.get(map.get(sortedStr)).add(strs[i]); // All we have to do is add it in the list already created, index will be figured out.
            } else {
                map.put(sortedStr, result.size());// KEY: This will help maintain the same index. 1st pair of anagram would be
                                                            // added in index 0 and so on. Result.size will always be the next index the new array list
                                                            // should be added to.
                result.add(new ArrayList<>(Arrays.asList(strs[i])));//
            }
        }
        return result;
    }
}
