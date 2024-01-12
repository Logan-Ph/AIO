#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <fstream>
#include <sstream>

using namespace std;

class Student
{
public:
    string name;
    int studentID;
    Student(string name, int studentID) : name{name}, studentID{studentID} {}
    ~Student() = default;
    virtual string toString() { return "name: " + name + ", student id: " + to_string(studentID); }
};

class Staff
{
public:
    string name;
    int staffID;
    Staff(string name, int staffID) : name{name}, staffID{staffID} {}
    ~Staff() = default;
    virtual string toString() { return "name: " + name + ", staff id: " + to_string(staffID); }
};

class Tutor : public Student, public Staff
{
public:
    string name;
    int id;
    Tutor(string name, int id) : Student(name, id), Staff(name, id), name{name}, id{id} {}
    void consultation() { cout << "Doing consultation !" << endl; }
    void setName(string aName) { name = aName; }
    string toString() { return "name: " + name + ", tutor id: " + to_string(id); }
};

class SchoolSystem
{
    vector<Student> *students;

public:
    SchoolSystem(vector<Student> *students = new vector<Student>()) : students{students} {};
    void addStudent()
    {
        string studentName;
        int studentID;
        cout << "Please enter student name:";
        getline(cin, studentName);
        cout << "Please student id: ";
        cin >> studentID;
        cin.ignore(1, '\n');
        students->push_back(Student(studentName, studentID));
        cout << "Add student successfully" << endl;
    }

    void removeStudent()
    {
        int studentID;
        cout << "Please enter student id to remove: " << endl;
        cin >> studentID;
        cin.ignore(1, '\n');
        auto it = find_if(students->begin(), students->end(), [studentID](Student &stu)
                          { return stu.studentID == studentID; });
        if (it == students->end())
        {
            cout << "The student ID does not exist!" << endl;
        }

        students->erase(it);
        cout << "Remove student successfully!" << endl;
    }

    void viewStudent()
    {
        if (size(*students) == 0)
        {
            cout << "There are no students in the system" << endl;
            return;
        }
        for (Student &st : *students)
        {
            cout << st.toString() << endl;
        }
    }

    void saveData()
    {
        ofstream file("students.dat");
        for (Student &st : *students)
        {

            file << st.toString() << endl;
        }
        file.close();
    }

    void getData()
    {
        ifstream file("students.dat");
        string line;
        while (getline(file, line))
        {
            istringstream iss(line);
            string studentName;
            string studentId;
            string discard; // to discard unwanted parts of the line

            getline(iss, discard, ':');          // discard "name"
            getline(iss, studentName, ',');      // get the student name
            studentName = studentName.substr(1); // remove leading space

            getline(iss, discard, ':');      // discard "student id"
            getline(iss, studentId);         // get the student id
            studentId = studentId.substr(1); // remove leading space
            students->push_back(Student(studentName, stoi(studentId)));
        }
        file.close();
    }
};

string
showInfoStudent(Student &stu)
{
    return stu.toString();
}

string showInfoStaff(Staff &staff)
{
    return staff.toString();
}

int main()
{
    int choice;
    SchoolSystem SchoolSystem;
    SchoolSystem.getData();
    while (choice != 4)
    {
        cout << "School Management System" << endl;
        cout << "1. View all students" << endl;
        cout << "2. Add Student" << endl;
        cout << "3. Remove Student" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter your choice: ";
        cin >> choice;
        cin.ignore(1, '\n');
        switch (choice)
        {
        case 1:
            SchoolSystem.viewStudent();
            break;
        case 2:
            SchoolSystem.addStudent();
            break;
        case 3:
            SchoolSystem.removeStudent();
            break;
        case 4:
            break;
        }
    }
    SchoolSystem.saveData();
}