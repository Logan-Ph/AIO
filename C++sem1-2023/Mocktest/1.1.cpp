#include <iostream>
#include <string>

class Employee
{
public:
    std::string name;
    double salary;
    Employee(std::string _name = "", double _salary = 0.0) : name{_name}, salary{_salary} {};
    void showInfo() { std::cout << "Employee "
                                << "name: " << name << " salary: " << salary << std::endl; };
};

class Manager : public Employee
{
public:
    double allowance;
    Manager(std::string _name = "", double _salary = 0.0, double _allowance = 0.0) : Employee(_name, _salary), allowance(_allowance){};
    void showInfo() { std::cout << "Manager: "
                                << "name: " << name << " salary: " << salary << " allowance: " << allowance << std::endl; };
};

int main(){
    Employee ep1 = Employee("Employee1" , 12);
    ep1.showInfo();
    Manager m1 = Manager("Manager1", 12, 13);
    m1.showInfo();
}