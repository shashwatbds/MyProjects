#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Sep 19 12:44:32 2021

@author: shashwat
"""

class HighestCommonFactor:
    
    @staticmethod
    def hcf(x,y):
        smaller = y if x>y else x
        s = smaller
        while s >0:
            if x%s==0 and y%s==0:
                break
            s-=1
        
        return s
        
        
print(HighestCommonFactor.hcf(150,100))