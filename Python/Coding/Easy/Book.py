#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sun Sep 19 13:50:23 2021

@author: shashwat
"""

class Book:
    
    def __init__(self,isbn, title,author,publisher,pages,price,copies):
        self.isbn = isbn
        self.title = title
        self.author = author
        self.publisher = publisher
        self.pages = pages
        self.price = price
        self.copies = copies
    
    @property
    def price(self):
       return self._price
 
    @price.setter
    def price(self, new_price):
       if 50 <= new_price <= 1000:
          self._price = new_price
       else:
           raise ValueError ('Price cannot be less than 50 or more than 500')

    def display(self):
        print(self.title)
        print(f'ISBN : {self.isbn}')
        print(f'Price : {self.price}')
        print(f'Number of copies : {self.copies}')
        print('.' * 50)
 
    def in_stock(self):
        return True if self.copies>0 else False
 
    def sell(self):
        if self.in_stock():
            self.copies -= 1
        else:
            print('The book is out of stock')
    
    
book1 = Book('957-4-36-547417-1', 'Learn Physics','Stephen', 'CBC', 350, 200,10)
book2 = Book('652-6-86-748413-3', 'Learn Chemistry','Jack', 'CBC', 400, 220,20)
book3 = Book('957-7-39-347216-2', 'Learn Maths','John', 'XYZ', 500, 300,5)
book4 = Book('957-7-39-347216-2', 'Learn Biology','Jack', 'XYZ', 400, 200,6)
 
book1.display()
book2.display()
book3.display()
book4.display()

books = [book1, book2, book3, book4]
 
for book in books:
    book.display()
 
jack_books = [book.title for book in books if book.author == 'Jack']
 
print(jack_books)

book5 = Book('957-7-39-347216-2', 'Learn Biology','Jack', 'XYZ', 400, 2030,6)
