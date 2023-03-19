# RMIT University Vietnam
# Course: COSC2429 Introduction to Programming
# Semester: 2022C
# Assignment: 3
# Author: Pham Phuoc Sang (s3975979)
# Created date: 14/1/2023
# Last modified date: 14/1/2023
# delete label named "delete"
#vs code

# define function
def delete_labels(student): 
    """
        strudent: dictionary contain information
        return dictionary with label deleted
    
    """
    new_student = {} #intialize dictionary
    for i in student:
        if student[i] != 'DELETED':
            new_student[i] = student[i] #delete the the label named "DELETE"

    return new_student

#define function
def write_in_txt(file_name,student):
    """
        file_name : path of the file
        student: the student information
        return : None
    """
    for i in student:
        with open(file_name,'a') as f:
            f.write(f"{i} : {student[i]}" + "\n") #write the information into the file


#main program
def main():
    student = {
    'ID': 's3962053',
    'Name': 'Huynh Tin',
    'University': 'RMIT',
    'Major': 'Information Technology',
    'Year': 2022,
    'Python': 'DI',
    'OOP': 'HD',
    'Network': 'DELETED',
    'C++': 'DI',
    'Web': 'DELETED',
    'Java': 'CR'
    }
    file_name = "output.txt" #create the file path 
    student = delete_labels(student) #call function
    write_in_txt(file_name,student) #call function

main()