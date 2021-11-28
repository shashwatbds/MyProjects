#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Sep 19 18:17:57 2021

@author: shashwat
"""

class Circle:
    
    def __init__(self, radius):
        self.radius = radius
    
    @property
    def radius(self):
        return self._radius
    
    @radius.setter
    def radius(self,new_radius):
        if new_radius >=0:
            self._radius = new_radius
        else:
            print('Radius can not be negative !!')
    
    @property
    def area(self):
        return 3.14 ** self.radius
    
    @property
    def circumference(self):
        return 2 * 3.14 * self.radius
    
    @property
    def diameter(self):
        return 2 * self.radius
    
c1 = Circle(5)
print(c1.area)
print(c1.diameter)
print(c1.circumference)