#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Nov 28 12:20:47 2021

@author: shashwat
"""

class Solution:
     
    # Python3 program to find the length
    # of the longest substring without
    # repeating characters
     
    # This functionr eturns true if all
    # characters in strr[i..j] are
    # distinct, otherwise returns false
    def areDistinct(self, strr, i, j):
     
        # Note : Default values in visited are false
        visited = [0] * (26)
     
        for k in range(i, j + 1):
            if (visited[ord(strr[k]) -
                       ord('a')] == True):
                return False
                 
            visited[ord(strr[k]) -
                    ord('a')] = True
     
        return True
     
    # Returns length of the longest substring
    # with all distinct characters.
    def lengthOfLongestSubstring(self, strr):
         
        n = len(strr)
         
        # Result
        res = 0
         
        for i in range(n):
            for j in range(i, n):
                if (self.areDistinct(strr, i, j)):
                    res = max(res, j - i + 1)
                     
        return res
        
        
        
solObj= Solution()
print(solObj.lengthOfLongestSubstring("abcabcbb"))
print(solObj.lengthOfLongestSubstring("pwwkew"))
print(solObj.lengthOfLongestSubstring(""))


