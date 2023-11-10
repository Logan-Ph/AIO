#include "string"
#include "iostream"
#include "fstream"
#include "vector"

using namespace std;


class Student{
private:
    string name;
    int score{};
    string password;
public:
    Student(const Student& rhs):name{rhs.name},score{rhs.score},password{rhs.password}{}
    Student() = default;
    Student(string &name, int score) : name{name}, score{score} {}
    inline string getName(){return name;}
    inline int getScore(){return score;}
    inline string getPassword(){return password;}
    inline bool changePwd();

    bool operator<(const Student &rhs) const {
        return score < rhs.score;
    }

    friend ostream &operator<<(ostream &os, const Student &student) {
        os << "name: " << student.name << ", score: " << student.score;
        return os;
    }
};

inline bool Student::changePwd() {
    if (!password.empty()){
        cout << "Enter the new password: "<<endl;
        getline(cin,password);
    }else{
        string passwd;
        cout << "Enter the old password to change: " << endl;
        getline(cin,passwd);
        if (passwd == password){
            cout << "Password correct" << endl;
            cout << "Enter the new password: "<<endl;
            getline(cin,password);
        }else
        {
            cout << "Password incorrect" << endl;
            return false;
        }
    }
    return true;
}

inline void writingStudents(const vector<Student> &students) {
    fstream file;
    file.open("name.dat", ios::app);
    for (const Student& student: students){
        file.write((char*)&student, sizeof(student));
    }
    file.close();
    cout << "Writing students to file successfully";
}

 inline vector<Student> readingStudents() {
    vector<Student> students;
    fstream file;
    file.open("name.dat", ios::in);
    while (!file.eof()){
        Student student;
        file.read((char*)&student,sizeof (student));
        students.push_back(student);
    }
    return students;
}

Student * findStudent(string &name, const vector<Student> &students){
    Student *stu = new Student;
    for (Student student:students){
        if (student.getName() == name){
            stu = &student;
            return stu;
        }
    }
    return stu;
}

inline void display(Student student) {
    cout << "1. Change password" << student.changePwd();
}

//int main(){
//    vector<Student> students;
//    students = readingStudents();
//    if (students.empty()){
//        cout << "Enter the number of students you want to add: " << endl;
//        int n;
//        cin >> n;
//        for (int i = 0; i < n; ++i) {
//            string name{};
//            int age{};
//            cout << "Enter the score: "<< endl;
//            cin >> age;
//            cout << "Enter the name: "<< endl;
//            cin.ignore(sizeof(age),'\n');
//            getline(cin,name);
//            Student stu(name,age);
//            students.push_back(stu);
//        }
//        for(int i=0; i<students.size();i++){
//            cout << i << ": " << students.at(i)<<endl;
//        }
//        string studentName;
//        cout << "Enter the student name: "<< endl;
//        getline(cin,studentName);
//        Student *student = findStudent(studentName,students);
//        if (student != nullptr){
//            display(*student);
//        } else{
//            cout << "Student does not exist" << endl;
//        }
//    }
//    else
//    {
//        for(int i=0; i<students.size();i++){
//            cout << i << ": " << students.at(i)<<endl;
//        }
//        string studentName;
//        cout << "Enter the student name: "<< endl;
//        getline(cin,studentName);
//        Student *student = findStudent(studentName,students);
//        if (student != nullptr){
//            display(*student);
//        } else{
//            cout << "Student does not exist" << endl;
//        }
//    }
//}