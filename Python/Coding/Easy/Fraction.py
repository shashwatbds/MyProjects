#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Sep 19 12:58:09 2021

@author: shashwat
"""

class Fraction:
    
    def __init__(self, numerator, denominator=1):
        self.numerator = numerator
        self.denominator = denominator
        if self.denominator < 0:
            self.numerator *= -1
            self.denominator *= -1
            
    def show(self):
        print('{}/{}'.format(self.numerator, self.denominator))
     
    def __str_(self):
        print('{}/{}'.format(self.numerator, self.denominator))
     
    def __mul__(self, other):
        new_numerator = self.numerator*other.numerator
        new_denominator = self.denominator*other.denominator
        f = Fraction(new_numerator, new_denominator)
        return f._reduce()
        
    def __add__(self, other):
        new_numerator = (self.numerator*other.denominator) + (other.numerator*self.denominator)
        new_denominator = self.denominator*other.denominator
        f = Fraction(new_numerator, new_denominator)
        return f._reduce()

    def __sub__(self, other):
        new_numerator = (self.numerator*other.denominator) - (other.numerator*self.denominator)
        new_denominator = self.denominator*other.denominator
        f = Fraction(new_numerator, new_denominator)
        return f._reduce()

    @staticmethod
    def hcf(x,y):
        smaller = y if x>y else x
        s = smaller
        while s >0:
            if x%s==0 and y%s==0:
                break
            s-=1
        
        return s
    
    def _reduce(self):
        hcf = self.hcf(self.numerator, self.denominator)
        print('Numerator:{} - Denominator:{} - hcf:{}'.format(self.numerator, self.denominator, hcf))
        new_denominator = self.denominator/hcf
        new_numerator = self.numerator/hcf
        return Fraction(new_numerator,new_denominator)
    
    def __eq__(self, other):
        return (self.numerator*other.denominator) == (self.denominator*other.numerator)
    
    def __lt__(self, other):
        return (self.numerator*other.denominator) < (self.denominator*other.numerator)
    
    def __le__(self, other):
        return (self.numerator*other.denominator) <= (self.denominator*other.numerator)
        
        
        
f1 = Fraction(2,3)
f1.show()
f2 = Fraction(3,4)
f2.show()
f3 = f1*f2
f3.show()
f3 = f1 + f2
f3.show()
f3 = f1 + 5 
f3.show()
f3 = f1*5 
f3.show()

f4 = Fraction(2,3)
f5 = Fraction(6,9)
print(f4==f5)
f6 = Fraction(3,4)
print(f4==f6)
print(f4!=f6)
print(f6<f5)