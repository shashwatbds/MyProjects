#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Dec  4 12:53:06 2021

@author: shashwat
"""


# Ading two number in linked list.
# Each number in is represented in reverse order i.e 564 is represented [4,6,5]
# The number of nodes in each list is in the range [1, 100]
# 0 <= List Item <= 9
# It is guaranteed that the list represents a number that does not have leading zeros.
class Solution:
    def addTwoNumbers(self, list1, list2) :

        l1 = len(list1)
        l2 = len(list2)
        
        if(l1>99 or l2 > 99):
            return "Invalid List length"
        if(list1[0] == 0 or list2[0]==0):
            return "List can not have leading Zeros"
        
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
            if(list1[i] > 9 or list2[i] > 9):
                return "Invalid list Items"
            sum = list1[i] + list2[i] + remainder
            remainder = round(sum//10)
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
print(sol.addTwoNumbers([9,9,9,9,9,9,9], [9,9,9,19]))
print(sol.addTwoNumbers([9,9,9,9,9,9,9], [0,9,9,1]))