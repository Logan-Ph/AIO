#include <iostream>
#include <string>
#include <algorithm>
#include <numeric>
#include <iomanip>

using namespace std;


class Employee{
protected:
    string name;
    double salary;
public:
    Employee() = default;
    Employee(string name, double salary);
    string showInfo();
};

Employee::Employee(string name, double salary):name{name}, salary{salary}{};

string Employee::showInfo(){
    string info = "Employee[name: "+ name + ", salary: "+ to_string(salary) + "]";
    return info;
}

class Manager: public Employee
{
private:
    double allowance;
public:
    Manager(string name, double salary, double allowance);
    Manager()=default;
    string showInfo();
    double getTotalIncome();
};

Manager::Manager(string name, double salary, double allowance): Employee(name,salary), allowance{allowance}{};

string Manager::showInfo(){
    string info = "Manager[name: "+ name + ", salary: "+ to_string(salary) + ", allowance: "+ to_string(allowance) + "]";
    return info;
}

double Manager::getTotalIncome(){
    return Employee::salary + allowance;
}

double getAverageIncome(Manager *managers){
    double sum = 0.0;
    for (int i=0; i<5;i++){
        sum+= managers[i].getTotalIncome();
    }
    return sum/5;
}

int main(){
    Manager *managers = new Manager[5];
    for (int i=0; i<5; i++){
        string name;
        double allowance, salary;
        cout << "Enter the name of the mananger: ";
        getline(cin,name);
        cout << "Enter the salary of the manager: ";
        cin >> salary;
        cin.ignore(sizeof(salary), '\n');
        cout << "Enter the allowance of the manager: ";
        cin >> allowance;
        cin.ignore(sizeof(allowance), '\n');
        managers[i] = Manager(name,salary,allowance);
        cout << managers[i].showInfo() << endl;
    }
    cout << "The average income: " <<  setprecision(3) << getAverageIncome(managers) << endl;
}