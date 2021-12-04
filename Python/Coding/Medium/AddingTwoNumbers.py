#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Dec  4 12:53:06 2021

@author: shashwat
"""

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, list1, list2) :

        l1 = len(list1)
        l2 = len(list2)
        
        if(l1>l2):
            length = l1
            list2 = self.adjustLength(list2,l1)
        elif(l2>l1):
            list1 = self.adjustLength(list1,l2)
        else:
            print("Equal")
        
        resultlist=[]
        remainder=0
        for i in range(0,len(list2)):
            print(list1[i])
            print(list2[i])
            print(remainder)
            sum = list1[i] + list2[i] + remainder
            print(sum)
            remainder = round(sum//10)
            print(remainder)
            resultlist.append(sum%10)
             
        if(remainder > 0 ):
            resultlist.append(remainder)
        return resultlist
    
    def adjustLength(self, lst, length):   
        count = length-len(lst)
        for w in range(0, count):
            lst.append(0)
        return lst
        
        

sol = Solution()
print(sol.addTwoNumbers([2,4,3], [5,6,4]))
print(sol.addTwoNumbers([9,9,9,9,9,9,9], [9,9,9,9]))