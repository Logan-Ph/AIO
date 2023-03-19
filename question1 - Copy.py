# RMIT University Vietnam
# Course: COSC2429 Introduction to Programming
# Semester: 2022C
# Assignment: 3
# Author: Pham Phuoc Sang (s3975979)
# Created date: 14/1/2023
# Last modified date: 14/1/2023
# Write a program which takes a string with words and numbers as an input from a user. Then 
#the program prints only the words in the input (without printing the digits) in reverse order as a string. 
# vs code

# define function
def delete_digits(user):    
    """
    user : the string from user
    return the string that delete the number
    """
    user = " ".join((i for i in user if not i.isdigit()))
    return user

#define function
def reverse_string(user):
    """
    user: the string
    return the reversed string
    
    """
    i = len(user)-1
    start = end = i+1
    result = ''
 
    #the main logic
    while i >= 0:
        if user[i] == ' ':
            start = i+1
            while start != end:
                result += user[start]
                start += 1
            result += ' '
            end = i
        i -= 1
    start = 0
    while start != end:
        result += user[start]
        start += 1
    return result

# main program
def main():
    user = input().split()#get input form user
    user = delete_digits(user) #call a function to delete the number inside the string
    user = reverse_string(user) #call a function to reveresed a string
    print(user)

main()
