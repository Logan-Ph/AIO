#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

class Student{
int score;
public:
    string name;
    Student(string name, int score):name{name},score{score}{};
    Student() = default;
    friend ostream &operator<<(ostream &os, Student &student);
    int get_score();
};

int Student::get_score(){
    return score;
}

ostream &operator<<(ostream &os, Student &student){
    return os << "Student[name = " << student.name << " , score = " << student.score << "]" << endl;
}

int main(){
    Student student1 = Student("Stud1" , 12);
    Student student2 = Student("Stud2" , 23);
    Student student3 = Student("Stud3" , 30);

    cout << student1;
    cout << student2;

    Student *students = new Student[3] {student1,student2,student3};
    for (int i=0; i<3;i++){
        cout << students[i];
    }
    sort_heap(students,students+3,[](Student stud1, Student stud2){return stud1.get_score()> stud2.get_score();});
    cout << "The student with the highest score is: ";
    cout << students[0] << endl;
}