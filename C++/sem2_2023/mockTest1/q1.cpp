#include <iostream>
#include <string>
#include <numeric>
#include <fstream>
#include <sstream>
#include <algorithm>

using namespace std;

class Student
{
private:
    string name;
    int *scores = new int[3];

public:
    Student() = default;
    Student(string name, int* scores = new int[3]): name{name}, scores{scores}{};
    void inputData(istream &is);
    friend istream &operator>>(istream &is, const Student &student);
    friend ostream &operator<<(ostream &os, Student &student);
    string showInfo();
    int *getScores();
    bool operator>(Student &rhs);
    friend Student operator+(int n, Student &student);
    string getName();
};

string Student::getName(){
    return name;
}

int *Student::getScores()
{
    return scores;
}

void Student::inputData(istream &is)
{
    cout << "Enter the name of the student: ";
    getline(is, name);
    cout << "Enter the scores of the student: ";
    for (int i = 0; i < 3; i++)
    {
        is >> scores[i];
    }
    is.ignore(sizeof(int), '\n');
}

string Student::showInfo()
{
    string info = "name: " + name + ", scores: ";
    for (int i = 0; i < 3; i++)
    {
        info += to_string(scores[i]) + " ";
    }
    return info;
}

Student operator+(int n, Student &student)
{
    int* scores = new int[3];
    string name = student.getName();
    for (int i = 0; i < 3; i++)
    {
        scores[i] = scores[i] + n;
    }
    Student *newStudent;
    newStudent = new Student(name,scores);
    return *newStudent;
}

istream &operator>>(istream &is, Student &student)
{
    student.inputData(is);
    return is;
}

ostream &operator<<(ostream &os, Student &student)
{
    return os << student.showInfo() << endl;
}

bool Student::operator>(Student &rhs)
{
    double avg1 = accumulate(scores, scores + 3, 0.0) / 3;
    double avg2 = accumulate(rhs.scores, rhs.scores + 3, 0.0) / 3;
    return avg1 > avg2;
}

void loadData(Student *students)
{
    ifstream myFile;
    myFile.open("data.txt");

    for (int i = 0; i < 10; i++)
    {
        string line;
        int *scores = new int[3];
        getline(myFile,line);
        stringstream ss;

        ss << line.substr(line.find(",")+2);
        string name = line.substr(0,line.find(","));
        ss >> scores[0] >> scores[1] >> scores[2];
        students[i] = Student(name,scores);        
    }
}

int main()
{
    Student *students = new Student[10];
    loadData(students);
    for (int i=0; i<10; i++){
        cout << students[i];
    }

    sort(students,students+10,[](Student s1, Student s2){return s1>s2;}
    );
    cout << students[0] << endl;
}