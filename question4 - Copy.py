# RMIT University Vietnam
# Course: COSC2429 Introduction to Programming
# Semester: 2022C
# Assignment: 3
# Author: Pham Phuoc Sang (s3975979)
# Created date: 14/1/2023
# Last modified date: 14/1/2023
# 
#vs code

# define class
class MyPoint:
    def __init__(self,x,y,z):
        self.x = x #create an atribute
        self.y = y#create an atribute
        self.z = z#create an atribute

    def __add__(self, other_self): #definte function add
        return MyPoint(self.x + other_self.x,self.y + other_self.y,self.z + other_self.z) #return a new point

    def __str__(self): #define function
        return f"({self.x},{self.y},{self.z})" 

#main program
def main():
    p1 = MyPoint(1,2,3) #create an object
    p2 = MyPoint(2,3,4) #create an object
    print(p1) 
    print(p2)
    p3 = p1+p2 #caculate the point
    print(p3)

main()
