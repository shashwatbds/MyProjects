#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Nov 28 12:20:47 2021

@author: shashwat
"""

class Solution:
     
    # Calculate the length
    # of the longest substring found in a string paremeter
    # without repeating characters
     
    # This functionr returns true if all
    # characters in s (from index i to j) are
    # distinct, otherwise returns false
    def areDistinct(self, s, i, j):
     
        visited = [0] * (26) #Boolean array of length 26 - length same as number of unique alphabets in English language.
        # Above array will be used to track duplicacy of an alphabet in a single run of function areDistinct
     
        for k in range(i, j + 1):
            if (visited[ord(s[k]) - ord('a')] == True):
                return False
                 
            visited[ord(s[k]) - ord('a')] = True
     
        return True
     
    # Returns length of the longest substring
    # with all distinct characters.
    def lengthOfLongestSubstring(self, s):
         
        n = len(s) # length of passed string parameter
         
        # Result
        res = 0
         
        for i in range(n):
            for j in range(i, n):
                if (self.areDistinct(s, i, j)):
                    res = max(res, j - i + 1) # could be 0 for first iteration.
                     
        return res
        
        
        
solObj= Solution()
print(solObj.lengthOfLongestSubstring("abcabcbb"))
print(solObj.lengthOfLongestSubstring("pwwkew"))
print(solObj.lengthOfLongestSubstring(""))


