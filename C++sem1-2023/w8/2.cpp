#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

class Department;
class Staff;

class Staff{
public:
    string name;
    Department *department;
    Staff(string name, Department *department):name{name},department{department}{};
    string getName(){return name;};
    Department *getDepartment(){return department;};
    bool joinDepartment(Department *dep);
    bool leaveDepartment(Department *dep);
};

class Department{
public:
    Staff *staff;
    string name;
    string location;
    vector<Staff*> *staff_list = new vector<Staff*>(); 
    Department(string name, string location, Staff *staff):name(name),location(location),staff(staff){};
};

class AcademicDepartment: public Department{
public:
    int numCourses;
    AcademicDepartment(string name, string location, Staff *astaff, int numCourses):Department(name,location,staff), numCourses{numCourses}{};
};

class NonAcademicDepartment: public Department{
public:
    int numServices;
    NonAcademicDepartment(string name, string locale, Staff *staff, int numServices): Department(name,location,staff), numServices{numServices}{};
};

bool Staff::joinDepartment(Department *dep){
    if (department == nullptr){
        dep->staff_list->push_back(this);
        department = dep;
        cout << "Joinning department succesfully";
        return true;
    }else{
        cout << "Can not join to this department" << endl;
        cout << "Joinning unsuccesfully" << endl;
        return false;
    }
}

bool Staff::leaveDepartment(Department *dep){
    if (dep == department && dep->staff != this){
        department = nullptr;
        auto *staffs = dep->staff_list;
        string staffName = name;
        auto found = find_if(staffs->begin(),staffs->end(),[staffName](Staff *staff){return staff->getName() == staffName;});
        staffs->erase(found);
        cout << "Leaving department succesfully" << endl;
        return true;
    }else{
        cout << "Cannot leave the department" << endl;
        return false;
    }
}

int main(){
    map<int,int> myMap;
    for (int i =0; i<4; i++){
        cout << "Enter a position: ";
        int pos;
        cin >> pos;
        cin.ignore(1, '\n');
        cout << "Enter a speed: ";
        int speed;
        cin >> speed;
        cin.ignore(1, '\n');
        myMap.insert({pos,speed});
    }

    for(auto iter = myMap.rbegin(); iter != myMap.rend(); ++iter){
        cout << iter->first << " " << iter->second << endl;
    }

    // vector<int> stack;
    // stack.push_back(3);
    // stack.push_back(2);

    // int t = stack.back();

    // for(auto &el: stack){
    //     cout << el << endl;
    // }
    // cout << t << endl;
}