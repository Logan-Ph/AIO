#include <iostream>
#include <vector>
#include "algorithm"

using namespace std;

class Staff;
class Department;

class Staff
{
private:
    Department *department = nullptr;
    string name;

public:
    explicit Staff(const string &name) : name(name) {}

    bool joinDepartment(Department &dep);
    bool leaveDepartment();
};

class Department
{
private:
    string name;
    string location;
    vector<Staff *> staffs;

public:
    Department(const string &name, const string &location) : name(name), location(location) {}
    void addStaff(Staff &staff);
    void removeStaff(Staff &staff);
};

class AcademicDepartment : public Department
{
private:
    int numCourses;

public:
    AcademicDepartment(const string &name, const string &location, int numCourses) : Department(name, location),
                                                                                     numCourses(numCourses) {}
};

class NonAcademicDepartment : public Department
{
private:
    int numServices;

public:
    NonAcademicDepartment(const string &name, const string &location, int numServices) : Department(name, location),
                                                                                         numServices(numServices) {}
};

void Department::addStaff(Staff &staff)
{
    staffs.push_back(&staff);
}

void Department::removeStaff(Staff &staff)
{
    auto it = find(staffs.begin(), staffs.end(), &staff);
    staffs.erase(it);
}

bool Staff::joinDepartment(Department &dep)
{
    if (department != nullptr)
    {
        cout << "This staff has already joint in different department!" << endl;
        return false;
    }
    else
    {
        department = &dep;
        dep.addStaff(*this);
        cout << "Joining department successfully" << endl;
        return true;
    }
}

bool Staff::leaveDepartment()
{
    if (department == nullptr)
    {
        cout << "This staff did not join any department!" << endl;
        return false;
    }
    else
    {
        department->removeStaff(*this);
        department = nullptr;
        cout << "Leaving department successfully" << endl;
        return true;
    }
}

int main()
{
    auto *dp1 = new Department("Dep1", "HCM");
    auto *dp2 = new Department("Dep2", "HCM");
    auto *dp3 = new Department("Dep3", "HCM");

    auto *staff1 = new Staff("staff1");
    auto *staff2 = new Staff("staff2");
    auto *staff3 = new Staff("staff3");

    staff1->joinDepartment(*dp1);
    staff2->joinDepartment(*dp1);
    staff3->joinDepartment(*dp1);

    staff1->leaveDepartment();
    staff1->leaveDepartment();
}