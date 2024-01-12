#include <iostream>
#include <string>
#include <algorithm>
#include <vector>

using namespace std;

class Staff;
class Department;

class Staff
{
    string name;
    Department *department;

public:
    Staff(string name = "", Department *department = nullptr) : name{name}, department{department} {};
    bool joinDept(Department &department);
    bool leaveDept();
    friend class Department;
};

class Department
{
    string name;
    string location;
    vector<Staff> staffList;

public:
    Department(string name = "", string location = "", vector<Staff> staffList = vector<Staff>()) : name{name}, location{location}, staffList{staffList} {};
    bool addStaff(Staff &staff);
    bool removeStaff(Staff &Staff);
    friend class Staff;
};

bool Staff::joinDept(Department &dept)
{
    if (department!= nullptr && department->name == dept.name)
    {
        cout << "You already join this department" << endl;
        return false;
    }

    if (department != nullptr)
    {
        cout << "You can not join this department! You need to leave your department first" << endl;
        return false;
    }

    dept.addStaff(*this);
    department = &dept;
    cout << "Join department successfully" << endl;
    return true;
}

bool Department::addStaff(Staff &staff)
{
    staffList.push_back(staff);
    return true;
}

bool Department::removeStaff(Staff &staff)
{
    auto it = find_if(staffList.begin(), staffList.end(), [staff](Staff &astaff)
                      { return staff.name == astaff.name; });
    if (it == staffList.end())
    {
        cout << "You are not in this department" << endl;
        return false;
    }

    if (size(staffList) == 1)
    {
        cout << "You are the last person of this department" << endl;
        return false;
    }
    staffList.erase(it);
    return true;
}

bool Staff::leaveDept()
{
    if (department == nullptr)
    {
        cout << "You are not join any department " << endl;
        return false;
    }

    if (department->removeStaff(*this))
    {
        department = nullptr;
        cout << "Leave department successfully" << endl;
        return true;
    }
    return false;
}

int main()
{
    Department dept("Dept1", "Location1");
    Staff st1("Staff1");
    Staff st2("Staff2");
    st1.joinDept(dept);
    st1.joinDept(dept);
}