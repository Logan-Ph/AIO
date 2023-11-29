#include <iostream>
#include <string>
#include <numeric>
#include <fstream>
#include <sstream>
#include <algorithm>

using namespace std;

class Student
{
    string name;
    int *scores;

public:
    Student(string name = "", int *scores = new int[3]) : name{name}, scores{scores} {};
    void inputData();
    string showInfo();
    friend ostream &operator<<(ostream &os, Student st);
    friend istream &operator>>(istream &is, Student &st);
    friend bool operator>(const Student &st1, const Student &st2);
    friend Student operator+(int n, Student &st);
};

Student operator+(int n, Student &st)
{
    Student newStudent;
    newStudent.name = st.name;
    for (int i = 0; i < 3; i++)
    {
        newStudent.scores[i] = st.scores[i] + n;
    }
    return newStudent;
}

bool operator>(const Student &st1, const Student &st2)
{
    return (accumulate(st1.scores, st1.scores + 3, 0) / 3 > accumulate(st2.scores, st2.scores + 3, 0) / 3);
}

ostream &operator<<(ostream &os, Student st)
{
    return os << "[name = " << st.name << ", scores: {" << st.scores[0] << ", " << st.scores[1] << ", " << st.scores[2] << "}]" << endl;
}

istream &operator>>(istream &is, Student &st)
{
    cout << "Please enter the name of the student: ";
    getline(is, st.name);
    for (int i = 0; i < 3; i++)
    {
        cout << "please enter the score of the student: ";
        is >> st.scores[i];
        cin.ignore(1, '\n');
    }
    return is;
}

void Student::inputData()
{
    cout << "Please enter the name of the student: ";
    getline(cin, name);
    for (int i = 0; i < 3; i++)
    {
        cout << "please enter the score of the student: ";
        cin >> scores[i];
        cin.ignore(1, '\n');
    }
}

string Student::showInfo()
{
    return "[name = " + name + ", scores: {" + to_string(scores[0]) + ", " + to_string(scores[1]) + ", " + to_string(scores[2]) + "}] \n";
}

Student getHighestScore(Student *sts)
{
    sort(sts, sts + 10, greater<Student>());
    return *(sts);
}

void fetchData()
{
    fstream inFile("data.txt", ios::in);
    stringstream ss;
    Student *students = new Student[10];
    for (int i = 0; i < 10; i++)
    {
        string line;
        getline(inFile, line);
        string name;
        int *score = new int[3];
        stringstream ss;
        auto it = line.find(',');
        name = line.substr(0, it - 1);
        ss << line.substr(it + 2);
        ss >> score[0];
        ss >> score[1];
        ss >> score[2];
        students[i] = *(new Student(name, score));
    }
    Student st = getHighestScore(students);
    cout << "The Student with highest score: " << endl;
    cout << st;
    inFile.close();
}

int main(int argc, char const *argv[])
{
    fetchData();
}
