#include <sstream>
#include "iostream"
#include "string"
using namespace std;

class Student{
private:
    string *name{};
    int *studentID{};
public:
    Student()=default;
    Student(string *name, int *studentId) : name(name), studentID(studentId) {
        cout << "Student object created successfully" << endl;
    }

    string toString(){
        stringstream str;
        str << "Student[studentID: " << *studentID << ", name: " << *name << "]" <<endl;
        return str.str();
    }

    int getStudentId() const {
        return *studentID;
    }

    virtual ~Student() {
        delete name;
        delete studentID;
    }
};

class Staff{
private:
    string *name{};
    int *staffID{};
public:
    Staff()= default;
    Staff(string *name, int *staffId) : name(name), staffID(staffId) {
        cout << "Staff constructor is called" << endl;
    }

    void setName(string *newName) {
        Staff::name = newName;
    }

    string toString(){
        stringstream str;
        str << "Staff[staffID: " << *staffID << ", name: " << *name << "]" << endl;
        return str.str();
    }

    int getStaffId() const {
        return *staffID;
    }

    virtual ~Staff() {
        delete name;
        delete staffID;
    }
};


class Tutor: public Staff, public Student{
public:
    Tutor() = default;
    Tutor(string *name, int *studentId, string *name1, int *staffId) :Staff(name1, staffId),Student(name, studentId) {}
    void consultation(){
        cout << "Doing consultation" << endl;
    }

    string toString(){
        stringstream str;
        str << Student::toString();
        str << Staff::toString();
        return str.str();
    }

};


//int main(){
//    Tutor tutor(new string("Sang") , new int(123), new string("Ngoc"), new int(456));
//}