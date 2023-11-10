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
    Student(string name, int studentID) : name{name}, studentID{studentID} {};
    string toString();
    ~Student() = default;
};

string Student::toString(){
    return "Student[name=" + name + ", studentID=" + to_string(studentID) + "]";
}

class SchoolSystem
{
public:
    vector<Student> *students;
    SchoolSystem(vector<Student> *astudents){
        students = astudents;
    };
    bool addStudent();
    bool removeStudent();
    void viewStudent();
};

void SchoolSystem::viewStudent(){
    if (size(*students)==0){
        cout << "There are no student in the system!"<< endl; 
    }else{
        for (Student stu:*students){
            cout << stu.toString() << endl;
        }
    }
}

bool SchoolSystem::removeStudent(){
    if (size(*students) == 0){
        cout << "There are no students in the system!" << endl;
        return false;
    }
    int studentID;
    cout << "Enter the student id to remove: ";
    cin >> studentID;
    cin.ignore(1,'\n');
    auto it = find_if(students->begin(), students->end(), [studentID](Student st)
                      { return st.studentID == studentID;});
    if (it != students->end()){
        students->erase(it);
        cout << "Remove student successfully!" << endl;
        return true;
    }else{
        cout << "The student does not existed in the system!" << endl;
        return false;
    }
}

bool SchoolSystem::addStudent()
{
    string name;
    int studentID;
    cout << "Enter the name of the student: ";
    getline(cin, name);
    cout << "Enter the student id: ";
    cin >> studentID;
    cin.ignore(1, '\n');
    auto it = find_if(students->begin(), students->end(), [name](Student st)
                      { return st.name == name;});
    if (it == students->end())
    {
        Student *std = new Student(name, studentID);
        students->push_back(*std);
        delete std;
        std = nullptr;
        return true;
    }else{
        cout << "The student already existed in the system!" << endl;
        return false;
    }
}

void writeData(vector<Student> *students){
    fstream myFile("students.dat",ios::out);
    for (Student &st: *students){
        myFile << st.studentID << " " << st.name;
    }
    myFile.close();
}   

vector<Student>* loadData(){
    vector<Student> *students = new vector<Student>();
    fstream myFile("students.dat",ios::in);
    while (!myFile.eof())
    {
        string line;
        stringstream ss;
        getline(myFile,line);
        if(line == ""){
            break;
        }
        ss<<line;
        int studentID;
        string studentName;
        ss >> studentID >> studentName;
        Student *st = new Student(studentName,studentID);
        students->push_back(*st);
    }
    myFile.close();
    return students;
}


int main()
{
    int choice;
    vector<Student> *students = loadData();
    SchoolSystem *schoolSystem = new SchoolSystem(students);
    while (true)
    {
        cout << "School Management System"<< endl;
        cout << "1. View all students"<< endl;
        cout << "2. Add Student"<< endl;
        cout << "3. Remove Student"<< endl;
        cout << "4. Exit"<< endl;
        cout << "Enter your choice: ";
        cin >> choice;
        cin.ignore(1,'\n');
        switch (choice)
        {
        case 1:
            schoolSystem->viewStudent();
            break;
        case 2:
            schoolSystem->addStudent();
            break;
        case 3:
            schoolSystem->removeStudent();
            break;
        }

        if (choice == 4){
            break;
        }
    }
    writeData(schoolSystem->students);
}