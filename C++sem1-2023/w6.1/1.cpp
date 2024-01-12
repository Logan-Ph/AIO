#include <iostream>
#include <string>

using namespace std;

class Student
{
    string name;
    int studentID;

public:
    Student(string name, int studentID) : name{name}, studentID{studentID} {}
    ~Student() = default;
    virtual string toString() { return "name: " + name + ", student id: " + to_string(studentID) + "/n"; }
};

class Staff
{
    string name;
    int staffID;

public:
    Staff(string name, int staffID) : name{name}, staffID{staffID} {}
    ~Staff() = default;
    virtual string toString() { return "name: " + name + ", staff id: " + to_string(staffID) + "\n"; }
};

class Tutor : public Student, public Staff
{
    string name;
    int id;

public:
    Tutor(string name, int id) : Student(name, id), Staff(name, id), name{name}, id{id} {}
    void consultation() { cout << "Doing consultation !" << endl; }
    void setName(string aName) { name = aName; }
    string toString() { return "name: " + name + ", tutor id: " + to_string(id) + "\n"; }
};

string showInfoStudent(Student &stu)
{
    return stu.toString();
}

string showInfoStaff(Staff &staff)
{
    return staff.toString();
}

int main()
{
    Student st1("st1", 12);
    Tutor t1("st2", 12);
    Staff staff1("staff1", 12);
    // cout << showInfoStaff(staff1);
    cout << showInfoStudent(t1);
}