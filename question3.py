# RMIT University Vietnam
# Course: COSC2429 Introduction to Programming
# Semester: 2022C
# Assignment: 3
# Author: Pham Phuoc Sang (s3975979)
# Created date: 14/1/2023
# Last modified date: 14/1/2023
# caculate and print out the total of the money investment
#vs code

# define function
def in_data_file_name(file_name):
    """
        file_name : name of the file
        return the amount of the money
    """ 
    amount = [] #initialize the list
    with open(file_name) as f: #open file
        for line in f:
            line = line.split(',') # split the value
            number_of_share = line[1]
            share_value = line[-1].split('\n')
            amount.append(int(number_of_share)*float(share_value[0])) #caculate thr total
    
    return amount

def data_file_name(amount):
    """
    amount : amount of money
    return sum all the amount of the money
    """
    return sum(amount) #sum of all the stock


#main program
def main():
    user = input("enter the file name: ") #get input from user
    amount = in_data_file_name(user) #call function
    amount = data_file_name(amount) #call function
    print(f"he total investment amount is: {amount}")


main()
    
