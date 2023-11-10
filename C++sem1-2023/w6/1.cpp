#include <iostream>
#include <string>

using namespace std;

class Student{
public:
    string name;
    int studentID;
    Student(string name, int studentID):name{name},studentID{studentID}{cout << "Invoke Student constructor" << endl;};
    string toString();
    ~Student() = default;
};

class Staff{
public:
    string name;
    int staffID;
    Staff(string name, int staffID):name{name},staffID{staffID}{cout << "Invoke Staff constructor" << endl;};
    ~Staff() = default;
    string toString();
};

class Tutor: public Student, public Staff{
public:
    Tutor(string name, int staffID, int studentID):Student(name, studentID), Staff(name, staffID){};
    void consultation();
    void setName(string name);
};

void Tutor::consultation(){
    cout << "Doing consultation !"<< endl;
}

void Tutor::setName(string name){
    Tutor::Student::name = name;
}

string Student::toString(){
    return "Student[name=" + name + ", studentID=" + to_string(studentID);
}

string Staff::toString(){
    return "Staff[name=" + name + ", studentID=" + to_string(staffID);
}

void showInfoStudent(Student &Stu){
    cout << Stu.toString() << endl;
}

void showInfoStaff(Staff &Staf){
    cout << Staf.toString() << endl;
}

