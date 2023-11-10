#include <iostream>
#include <string>

using namespace std;

class Person{
private:
    string name;

public:
    explicit Person(const string &name): name{name}{};
    string getName() const;

};

class Student: public Person
{
private:
    int semester;
public:
    Student(int semester, const string &name): Person::Person{name}, semester{semester}{};
    int getSemester() const;
};

string Person::getName() const{
    return name;
}

int Student::getSemester() const{
    return semester;
}