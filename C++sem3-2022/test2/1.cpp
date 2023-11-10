#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

class Vehicle{
private:
    string name;
    int year;
public:
    Vehicle() = default;
    Vehicle(string name, int year): year{year}, name{name}{};
    int getYear(){return year;};
    string getName(){return name;};
};

class Car:public Vehicle{
private:
    int plateNumber;
public:
    Car() = default;
    Car(string name, int year, int plateNumber): Vehicle(name,year), plateNumber{plateNumber}{};
};

int main(){
    Car *car1 = new Car("car1",1000,123);
    Car *car2 = new Car("car2",1234,123);
    Car *car3 = new Car("car3",4000,123);

    Car *cars[] = {car3,car2,car1};

    sort(cars,cars+3,[](Car *car1, Car *car2){return (car1->getYear()< car2->getYear())? true:false;});
    cout << cars[0]->getName() << " - " << cars[0]->getYear() << endl;
}