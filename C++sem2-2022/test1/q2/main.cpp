#include <string>
#include <iostream>
#include <numeric>

using namespace std;

class Student{
    string &name;
    int scores[3]{};
public:
    Student() = default;
    void inputData();
    void showInfo();
};

void Student::inputData() {
    getline(cin,name);
}

void Student::showInfo() {
    cout << "name: " << name << ", scores: ";
    
}

int main(){
    Student *student;
    student->inputData();
}
