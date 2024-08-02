package org.example.blind75.arraysandhashing.medium;

import java.util.*;

/**
 * Amazon, Netflix, Microsoft
 * */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        System.out.println(obj.groupAnagramsSorting(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(obj.groupAnagramsSorting(new String[]{"a"}));
        System.out.println(obj.groupAnagramsSorting(new String[]{""}));
        System.out.println("\nEfficient Code");
        System.out.println(obj.groupAnagramsEfficient(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(obj.groupAnagramsEfficient(new String[]{"a"}));
        System.out.println(obj.groupAnagramsEfficient(new String[]{""}));
    }

    /**
     *
     * */
    public List<List<String>> groupAnagramsEfficient(String[] strs) {

        if(strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> ansMap = new HashMap<>();
        int[] count = new int[26];
        for(String s: strs) {
            Arrays.fill(count, 0);
            for(char c: s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i=0; i<26; i++) {
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

    /***
     * Sorting
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
            if(map.containsKey(sortedStr)) {
                result.get(map.get(sortedStr)).add(strs[i]);
            } else {
                map.put(sortedStr, result.size());//this will help maintain the same index.
                result.add(new ArrayList<>(Arrays.asList(strs[i])));//
            }
        }
        return result;
    }
}
