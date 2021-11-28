#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Sep 19 20:06:17 2021

@author: shashwat
"""

class SalesPerson:
    names = []
    total_revenue = 0
    
    def __init__(self,name, age):
        self.name = name
        self.age = age
        self.sales_amount = 0
        SalesPerson.names.append(name)
        
    def make_sale(self, amount):
        self.sales_amount+=amount
        SalesPerson.total_revenue +=amount
        
    def show(self):
        print(self.name, self.age, self.sales_amount)
 
    
s1 = SalesPerson('Bob', 25)
s2 = SalesPerson('Ted', 22)
s3 = SalesPerson('Jack', 27)
 
s1.make_sale(1000)
s1.make_sale(1200)
s2.make_sale(5000)
s3.make_sale(3000)
s3.make_sale(8000)

s1.show()
s2.show()
s3.show()

print(SalesPerson.total_revenue)
print(SalesPerson.names)