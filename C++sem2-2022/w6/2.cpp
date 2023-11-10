#include <vector>
#include <algorithm>
#include <fstream>
#include <iterator>
#include <sstream>
#include "iostream"
#include "string"
#include "numeric"
using namespace std;

class Student{
private:
    string *name{};
    int *studentID{};
public:
    Student()=default;
    Student(string *name, int *studentId) : name(new string(*name)), studentID(new int (*studentId)) {
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

class SchoolSystem{
private:
    vector<Student*> *students = new vector<Student*>();
public:
    SchoolSystem()=default;

    void addStudent(){
        int tempID;
        string tempName;
        cout << "Please enter the id of the student: " << endl;
        cin >> tempID;
        cin.ignore(numeric_limits<streamsize>::max(),'\n');
        cout << "Please enter the name of the student: " << endl;
        getline(cin, tempName);
        Student *student = new Student(new string(tempName),new int(tempID));
        students->push_back(student);
    }

    void removeStudent(){
        int studentID{};
        cout << "Please enter the student ID to remove: " << endl;
        cin >> studentID;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        auto student = find_if(students->begin(), students->end(), [&studentID](const Student* student) {return student->getStudentId() == studentID;});
        if (student == students->end()) {
            cout << "The student does not exist in the system" << endl;
        } else {
            students->erase(student);
        }
    }

    void displayAllStudents(){
        for ( Student *student: *students){
            cout << student->toString();
        }
    }

    void setStudents(vector<Student*> *studentsVec) {
        this->students = studentsVec;
    }

    vector<Student*>* getStudents() {
        return students;
    }
};

void writeData(SchoolSystem schoolSystem) {
    ofstream file;
    file.open("students.dat", ios::out);
    file.write((char*)&schoolSystem, sizeof (schoolSystem));
    file.close();
    cout << "Writing students to file successfully";
};

SchoolSystem readingData() {
    SchoolSystem schoolSystem;
    ifstream file;
    file.open("students.dat", ios::in);
    file.read((char*)&schoolSystem, sizeof(schoolSystem));
    return schoolSystem;
};

void initializeSystem(){
    int choice;
    SchoolSystem schoolSystem = readingData();
    while (true){
        cout << "School Management System" << endl;
        cout << "1. View all students" << endl;
        cout << "2. Add Student" << endl;
        cout << "3. Remove student" << endl;
        cout << "4. Exit" << endl;
        cout << "Enter your choice: " << endl;
        cin >> choice;
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        switch (choice) {
            case 1:
                schoolSystem.displayAllStudents();
                break;
            case 2:
                schoolSystem.addStudent();
                break;
            case 3:
                schoolSystem.removeStudent();
                break;
            case 4:
                break;
            default:
                cout << "You have to enter the choice !!" << endl;
                break;
        }
        if (choice == 4){
            break;
        }
    }
    writeData(schoolSystem);
}

int main(){
    initializeSystem();
}