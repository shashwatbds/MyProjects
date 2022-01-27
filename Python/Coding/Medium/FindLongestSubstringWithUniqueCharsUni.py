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
     
    # This function returns true if all
    # characters in s (from index i to j) are
    # distinct, otherwise returns false
    def lengthOfLongestSubstring(self, s):
        lsub = 0
        for i in range(len(s)):
            curr = ""
            for j in range(i, len(s)):
                if s[j] not in curr:
                    curr += s[j]
                    lsub = max(lsub, len(curr))
                else:
                    break
        return lsub    
        
        
solObj= Solution()
print(solObj.lengthOfLongestSubstring("abcabcbb"))
print(solObj.lengthOfLongestSubstring("pwwkew"))
print(solObj.lengthOfLongestSubstring("aabaab!bb"))


