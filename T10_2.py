class Student:
    def __init__(self,name:str,age:int,GPA:float):
        self.name = name
        self.age = age
        self.GPA = GPA
    
    def __str__(self):
        return f"Student name: {self.name}, age:{self.age}, GPA:{self.GPA}"

stud = Student("Jessa", 20, 3.2) 
print(stud)

stud.set_GPA(2.9)  
print(stud)

stud.set_name("Jessia")  
print(stud)