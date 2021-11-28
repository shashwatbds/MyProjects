#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Sep 17 11:30:45 2021

@author: shashwat
"""

class BankAccount:
    
    BANK_NAME = 'SBI'
    
    def __init__(self, name, bank=BANK_NAME, balance=0):
        self.name = name
        self.balance = balance
        self.bank = bank
        self.__privatevariable = 9
    
    def withdraw(self, amount):
        self.balance -= amount
        self.display()
    
    
    def deposit(self, amount):
        self.balance += amount
        self.display()
    
    def display(self):
        print('Hi, {} your account balance is {} and private variable value is {}'.format(self.name, self.balance, self._BankAccount__privatevariable))
        
        
b1 = BankAccount('Shashwat Bhardwaj', '',100)
b1.deposit(100)
b1.withdraw(10)



