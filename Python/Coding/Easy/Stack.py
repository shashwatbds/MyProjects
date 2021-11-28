#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Mon Sep 20 11:06:29 2021

@author: shashwat
"""

class Stack:
    
    MAX_SIZE = 100
    
    def __init__(self):
        self.items = []
        
    @property
    def top(self):
        return len(self.items)
        
        
    def push(self, element):
        if self.top == Stack.MAX_SIZE:
            raise RuntimeError('Stack already full.')
        else:
            self.items.append(element)
        
    def pop(self):
        if self.top == 0:
            raise RuntimeError('Stack already empty.')
        else:
            self.items.pop(self.top-1)
    
    def show(self):
        print(self.items)
        
    def is_empty(self):
        return self.items == []
        
if __name__ == "__main__":
    st = Stack()
 
    while True:
        print("1.Push") 
        print("2.Pop") 
        print("3.Peek") 
        print("4.Size")
        print("5.Display") 
        print("6.Quit")
         
        choice = int(input("Enter your choice : "))
 
        if choice == 1:
            x=int(input("Enter the element to be pushed : "))
            st.push(x) 
        elif choice == 2:
            x=st.pop() 
            print("Popped element is : " , x) 
        elif choice == 3:
            print("Element at the top is : " , st.peek()) 
        elif choice == 4:
            print("Size of stack " , st.top) 
        elif choice == 5:
            st.show()         
        elif choice == 6:
          break;
        else:
          print("Wrong choice") 
        print() 
