#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 10:20:22 2021

@author: shashwat
"""
class Person:
    def display(self):
        print('I am a person.')
        
        
    def greet(self):
        print('Hello, How are you?')



id(Person)
p1 = Person()
p2 = Person()

type(p1)
id(p1)

p1.display()
p2.display()

p1.greet()
p2.greet()
