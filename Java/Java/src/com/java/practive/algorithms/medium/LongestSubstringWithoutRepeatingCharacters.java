package com.java.practive.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println("abcabcbb has - "+findLengthOfLongestSubstringWithoutRepeatingCharacters("abcabcbb")+" maximum of consecutive unique chars");
		System.out.println("bbbbb has - "+findLengthOfLongestSubstringWithoutRepeatingCharacters("bbbbb")+" maximum of consecutive unique chars");
		System.out.println("pwwkew has - "+findLengthOfLongestSubstringWithoutRepeatingCharacters("pwwkew")+" maximum of consecutive unique chars");
		System.out.println("Hello has - "+findLengthOfLongestSubstringWithoutRepeatingCharacters("Hello")+" maximum of consecutive unique chars");

		System.out.println("abcabcbb has - "+findLongestSubstringWithoutRepeatingCharacters("abcabcbb")+" as longest substring with unique chars");
		System.out.println("bbbbb has - "+findLongestSubstringWithoutRepeatingCharacters("bbbbb")+" as longest substring with unique chars");
		System.out.println("pwwkew has - "+findLongestSubstringWithoutRepeatingCharacters("pwwkew")+" as longest substring with unique chars");
		System.out.println("Hello has - "+findLongestSubstringWithoutRepeatingCharacters("Hello")+" as longest substring with unique chars");

	}

	/**
	 * Longest Substring Without Repeating Characters.
	 * Given a string s, find the length of the longest substring without repeating characters.
	 * Example 1:
		Input: s = "abcabcbb"
		Output: 3
		Explanation: The answer is "abc", with the length of 3.

		Example 2:
		Input: s = "bbbbb"
		Output: 1
		Explanation: The answer is "b", with the length of 1.

		Example 3:
		Input: s = "pwwkew"
		Output: 3
		Explanation: The answer is "wke", with the length of 3.
		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 * */
	public static int findLengthOfLongestSubstringWithoutRepeatingCharacters(String str) {

		int n = str.length();
		int res = 0;

		for(int i = 0; i < n; i++)
		{

			boolean[] visited = new boolean[256]; //only 256 total chars possible, 
			//this considers all types of chars, int, chars and special chars.
			// each char has a unique alphanumeric code (0-256) and we will store true false on that 
			// alphanumeric index when the char is present.

			for(int j = i; j < n; j++)
			{
				if (visited[str.charAt(j)] == true)
					break;

				else
				{
					res = Math.max(res, j - i + 1);
					visited[str.charAt(j)] = true;
				}
			}
			visited[str.charAt(i)] = false;
		}
		return res;
	}

	/**
	 * Longest Substring Without Repeating Characters.
	 * Given a string s, find the length of the longest substring without repeating characters.
	 * Example 1:
		Input: s = "abcabcbb"
		Output: "abc"
		Explanation: The answer is "abc".

		Example 2:
		Input: s = "bbbbb"
		Output: "b"
		Explanation: The answer is "b".

		Example 3:
		Input: s = "pwwkew"
		Output: "wke"
		Explanation: The answer is "wke".
		Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 * */
	public static String findLongestSubstringWithoutRepeatingCharacters(String str) {
		String substr = "";
		int len = str.length();
		for(int i=0; i<len; i++) {
			Set<Character> visited = new HashSet<Character>(); //only 256 total chars possible, 
			//this considers all types of chars, int, chars and special chars.
			// each char has a unique alphanumeric code (0-256) and we will store true false on that 
			// alphanumeric index when the char is present.
			int j = i;
			for(; j<len; j++) {
				char currChar = str.charAt(j);
				if(visited.contains(currChar)) {
					break;
				} else {
					visited.add(currChar);
				}
			}

			if (substr.length() < j - i + 1) {
				substr = str.substring(i, j);
			}
		}
		return substr.toString();
	}
}
