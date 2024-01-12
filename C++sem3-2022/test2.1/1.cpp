#include <iostream>
#include <string>
#include <vector>

class Vehicle
{
public:
    std::string name;
    int year;
    Vehicle(std::string _name = "", int _year = 0) : name{_name}, year{_year} {};
};

class Car : public Vehicle
{
public:
    int plateNumber;
    Car(std::string _name = "", int _year = 0, int _plateNumber = 0) : Vehicle(_name, _year), plateNumber(_plateNumber){};
    friend std::ostream& operator<<(std::ostream &os, Car *car)
    {
        os << car->name << " " << car->year << " " << car->plateNumber;
        return os;
    };
};

void findOldestCar(std::vector<Car*> cars){
    Car *oldestCar = cars.at(0);
    for (Car *car : cars){
        if (car->year < oldestCar->year){
            oldestCar = car;
        }
    }
    std::cout << "The oldest car is " << oldestCar->name << std::endl;
}

int main()
{
    Car *bmw = new Car("BMW", 1998, 123);
    Car *mec = new Car("Mec", 2001, 1234);
    Car *porchse = new Car("Porchse", 1700, 351);
    findOldestCar({bmw,mec,porchse});
}