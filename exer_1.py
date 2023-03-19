# RMIT University Vietnam
# Course: COSC2429 Introduction to Programming
# Semester: 2022C
# Assignment: 3
# Author: Pham Phuoc Sang (s3975979)
# Created date: 14/1/2022
# Last modified date: 14/1/2022
# function of the code
#vs code

# define function
def count(digit,letter,symbol,given_string):
    '''
    digit: digit in string
    letter: letter in string 
    symbol: special symbol in string
    given_string: string from user
    return digit, letter, and special symbol
    
    '''
    for i in given_string:
        if i.isalpha(): #check if is words
            letter+=1
        elif i.isdigit(): #check if is digits
            digit+=1
        else: 
            symbol +=1

    return digit,letter,symbol

#main program
def main():
    letter = 0 #intialize value
    digit = 0  #intialize value
    symbol = 0  #intialize value
    given_string = input("Enter s string: ").strip()  #get input from user
    digit,letter,symbol = count(digit,letter,symbol,given_string) #call function
    print("Letters: ",letter)
    print("Digits: ", digit)
    print("Symbols: ", symbol)

main()