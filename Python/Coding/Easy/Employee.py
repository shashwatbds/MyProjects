#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Sep 19 20:46:47 2021

@author: shashwat
"""

class Employee:    
    
    domains = []
    allowed_domains = ['yahoo.com', 'gmail.com', 'outlook.com']
    
    def __init__(self,name,email):
        self.name = name
        self.email = email
        domain = self.fetch_domain()
        if domain in Employee.allowed_domains:
            Employee.domains.append(domain)
        else:
            raise ValueError('Invalid domain!!')
   
    def display(self):
        print(self.name, self.email)
        
    def fetch_domain(self):
       return self.email.split('@')[1]
            
e1 = Employee('John','john@gmail.com')
e2 = Employee('Jack','jack@yahoo.com')
e3 = Employee('Jill','jill@outlook.com')
e4 = Employee('Ted','ted@yahoo.com')
e5 = Employee('Tim','tim@gmail.com')
e6 = Employee('Mike','mike@yahoo.com')

print(Employee.domains)