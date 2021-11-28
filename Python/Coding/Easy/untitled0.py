#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Oct 17 16:28:43 2021

@author: shashwat
"""

class Person:
    
    def speak(self, greeting):
        print(greeting)
        
    def introduce(self):
        print("Hi, I am {} {} and I am {} years old".format(self.fname,self.lname,self.age))
        

rohit = Person()
rohit.fname="Rohit"
rohit.lname="Chamle"
rohit.age=24
rohit.introduce()
rohit.speak("Hello, how are you?")


p2 = Person()
p2.fname="Shashwat"
p2.lname="Bhardwaj"
p2.age=32
p2.introduce()
p2.speak("Hello, how are you?")
