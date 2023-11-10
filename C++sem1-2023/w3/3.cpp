#include <iostream>
#include <string>
#include <algorithm>
#include <fstream>
#include <map>
#include <sstream>

using namespace std;

class Student
{
    int score;
    string password;

public:
    string name;
    Student(string name, int score) : name{name}, score{score} {};
    Student() = default;
    friend ostream &operator<<(ostream &os, Student &student);
    int get_score();
    bool changePwd();
};

bool Student::changePwd()
{
    map<string, string> students;
    fstream myFile;
    myFile.open("name.dat", ios::in | ios::out);
    while (!myFile.eof())
    {
        string line;
        getline(myFile, line);
        size_t pos = line.find(":");
        string name = line.substr(0, pos);
        string pass = line.substr(pos + 1);
        students[name] = pass;
    }
    myFile.close();

    if (students.find(name) != students.end())
    {
        string oldpass;
        cout << "Enter the old password: ";
        getline(cin, oldpass);

        if (oldpass == students[name])
        {
            string newPass;
            cout << "Enter the new password: ";
            getline(cin, newPass);
            students[name] = newPass;
        }
        else
        {
            cout << "Wrong password!" << endl;
            return false;
        }
    }
    else
    {
        string newPass;
        cout << "Enter the new password: ";
        getline(cin, newPass);
        students[name] = newPass;
    }

    myFile.open("name.dat", ios::in | ios::out);
    for (auto it:students){
        myFile << it.first << ":" << it.second <<endl;
    }
    myFile.close();
    return true;
}

int Student::get_score()
{
    return score;
}

ostream &operator<<(ostream &os, Student &student)
{
    return os << "Student[name = " << student.name << " , score = " << student.score << "]" << endl;
}

int main()
{
    Student student1 = Student("Stud1", 12);
    Student student2 = Student("Stud2", 23);
    Student student3 = Student("Stud3", 30);
    Student *students = new Student[3]{student1, student2, student3};
    for (int i = 0; i < 3; i++)
    {
        cout << students[i];
        if (students[i].changePwd())
        {
            cout << "Saved password successfully" << endl;
        }
        else
        {
            cout << "Saved password unsuccessfully" << endl;
        }
    }
}