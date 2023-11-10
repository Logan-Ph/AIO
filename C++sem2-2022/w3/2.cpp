#include "iostream"
#include "string"
#include "algorithm"
#include "vector"
using namespace std;

class Student{
private:
    string name;
    int score{};
    string password;
public:
    Student() = default;
    Student(string &name, int score) : name(name), score(score) {}
    inline string getName(){return name;}
    inline int getScore(){return score;}

    bool operator<(const Student &rhs) const {
        return score < rhs.score;
    }

    bool operator>(const Student &rhs) const {
        return score > rhs.score;

    }

    friend ostream &operator<<(ostream &os, const Student &student) {
        os << "name: " << student.name << ", score: " << student.score;
        return os;
    }
};

//int main(){
//    vector<Student> students{};
//    for (int i = 0; i < 2; ++i) {
//        string name{};
//        int age{};
//        cout << "Enter the score: "<<endl;
//        cin >> age;
//        cout << "Enter the name: "<<endl;
//        cin.ignore(sizeof(age),'\n');
//        getline(cin,name);
//        Student stu(name,age);
//        students.push_back(stu);
//    }
//    sort(students.begin(), students.end());
//    cout << students.back();
//}