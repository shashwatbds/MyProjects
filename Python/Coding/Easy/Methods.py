#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Oct  9 16:59:08 2021

@author: shashwat
"""

#Replace all ______ with rjust, ljust or center. 
def method1():
    num=int(input("Enter number: "))
    total=0
    while num != -1:
        total+=num
        num=int(input("Enter number: "))

        
    print(total)
        
 
method1()